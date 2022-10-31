package lu.atozdigital.api.Services;


import lu.atozdigital.api.Entities.Article;
import lu.atozdigital.api.Repositories.ArticleRepo;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;


@Service
public class ArrticleService {

    @Autowired
    private ArticleRepo articleRepo;


    public Article createSaveArticle(MultipartFile file,String name,Long price) throws IOException {

        //Better use service however i'm too lazy to do so
        String Path_Dir = "D:\\spring-angular-test\\api\\src\\main\\resources\\static\\imgs";
        Files.copy(file.getInputStream(), Paths.get(Path_Dir+ File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        Article art1 =  new Article();
        art1.setName(name);
        art1.setPrice(price);
        art1.setImg(file.getBytes());

        return this.articleRepo.save(art1);
    }


    public List<Article> GetAllArticles(){
        return  this.articleRepo.findAll();
    }

    public List<Article> getArticlesByName(String name){

        List<Article> articles = this.articleRepo.findByName(name);

        if(articles.size()>0)
            return articles;
        else
            return null;
    }
}
