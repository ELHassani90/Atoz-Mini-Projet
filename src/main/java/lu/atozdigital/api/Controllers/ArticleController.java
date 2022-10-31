package lu.atozdigital.api.Controllers;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lu.atozdigital.api.Entities.Article;
import lu.atozdigital.api.Entities.Ordr;
import lu.atozdigital.api.Entities.User;
import lu.atozdigital.api.Repositories.ArticleRepo;
import lu.atozdigital.api.Repositories.OrderRepo;
import lu.atozdigital.api.Repositories.UserRepo;
import lu.atozdigital.api.Services.ArrticleService;
import lu.atozdigital.api.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.plaf.multi.MultiPanelUI;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.List;


 ////////////////////////////////////////  Writer name :  EL HASSANI ABDERRAHMAN //////////////////////////////////
@RestController
@RequestMapping("/api")
public class ArticleController {
    @Autowired
    private ArrticleService arrticleService;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OrderService orderService;


    @ResponseBody
    @PostMapping("/article")
    public Article CreateArticle(@RequestParam("file")MultipartFile file,@RequestParam("name")String name,@RequestParam("price") Long price) throws IOException {
        return arrticleService.createSaveArticle(file, name, price);
    }

     @GetMapping("/Allarticles")
     public List<Article> GetAllArticles(){
         return arrticleService.GetAllArticles();
     }

     @GetMapping("/Allarticles/{name}")
     public List<Article> GetArticlesByNmae(@RequestParam("name") String name){
         return arrticleService.getArticlesByName(name);
     }
/*     @GetMapping("/Allarticles")
     public ResponseEntity<?> GetAllArticles(){
         List<Article> res = arrticleService.GetAllArticles();

         return ResponseEntity.status(HttpStatus.OK)
                 .contentType(MediaType.valueOf("image/png"))
                 .body(res.get(1).getImg());
     }*/

    @PostMapping("/setuser")
    public User CreateUser(@RequestBody User user){
        return this.userRepo.save(user);
    }



     @GetMapping("/getUsers")
     public List<User> GetUsers(){
         return this.userRepo.findAll();
     }

     @GetMapping("/orders")
     public List<Ordr> CreateAllOrdrs(){
         return orderService.GetAllOrdesr();
     }


     @PostMapping("/order")
     public  Ordr createOrder(@RequestBody Ordr order){
        return orderService.SaveOrder(order);
     }

     @GetMapping("/ordersCount")
     public Long getOrdersCount(){
        return  orderService.countOrders();
     }
}
