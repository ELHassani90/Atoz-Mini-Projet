package lu.atozdigital.api.Repositories;

import lu.atozdigital.api.Entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepo extends JpaRepository<Article,Long> {

    List<Article> findByName(String name);
}
