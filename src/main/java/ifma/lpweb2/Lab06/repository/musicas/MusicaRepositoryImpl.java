package ifma.lpweb2.Lab06.repository.musicas;

import ifma.lpweb2.Lab06.model.Musica;
import ifma.lpweb2.Lab06.repository.filter.MusicaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MusicaRepositoryImpl implements MusicaRepositoryQuery{
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Musica> filtrar(MusicaFilter filtro, Pageable pageable) {

        CriteriaBuilder cBuilder = manager.getCriteriaBuilder();

        CriteriaQuery<Musica> cQuery = cBuilder.createQuery(Musica.class);

        Root<Musica> produtoRoot = cQuery.from(Musica.class);

        Predicate[] restricoes = this.criaRestricoes(filtro, cBuilder, produtoRoot);


        cQuery.select(produtoRoot)
                .where(restricoes )
                .orderBy( cBuilder.desc(produtoRoot.get("nome")));

        TypedQuery<Musica> query = manager.createQuery(cQuery);
        adicionaRestricoesDePaginacao(query, pageable);

        return new PageImpl<Musica>(query.getResultList(), pageable, total(filtro));
    }


    private Predicate[] criaRestricoes(MusicaFilter filtro, CriteriaBuilder cBuilder, Root<Musica> produtoRoot) {

        List<Predicate> predicates = new ArrayList<>();

        if ( !StringUtils.isEmpty(filtro.getNome())) {
            predicates.add(cBuilder.like(cBuilder.lower(produtoRoot.get("nome")), "%" + filtro.getNome().toLowerCase() + "%" ) );
        }

        if ( Objects.nonNull(filtro.getDuracao()) ) {
            predicates.add( cBuilder.ge( produtoRoot.get("duracao"), filtro.getDuracao() ));
        }

        return predicates.toArray(new Predicate[ predicates.size() ] );
    }

    private void adicionaRestricoesDePaginacao(TypedQuery<Musica> query, Pageable pageable) {
        Integer paginaAtual = pageable.getPageNumber();
        Integer totalObjetosPorPagina = pageable.getPageSize();
        Integer primeiroObjetoDaPagina = paginaAtual * totalObjetosPorPagina;

        // 0 a n-1, n - (2n -1), ...
        query.setFirstResult(primeiroObjetoDaPagina );
        query.setMaxResults(totalObjetosPorPagina );

    }

    private Long total(MusicaFilter filtro) {
        CriteriaBuilder cBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> cQuery = cBuilder.createQuery(Long.class);

        Root<Musica> musicaRoot = cQuery.from(Musica.class);

        Predicate[] predicates = criaRestricoes(filtro, cBuilder, musicaRoot);

        cQuery.where(predicates );
        cQuery.select( cBuilder.count(musicaRoot) );

        return manager.createQuery(cQuery).getSingleResult();
    }

}
