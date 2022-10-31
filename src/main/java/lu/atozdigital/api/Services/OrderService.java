package lu.atozdigital.api.Services;

import lu.atozdigital.api.Entities.Ordr;
import lu.atozdigital.api.Repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;


    public Ordr SaveOrder(Ordr or){
        Ordr ordr = new Ordr();
        ordr.setReference(GenerateRef(15));
        ordr.setDate(or.getDate());
        ordr.setArticals(or.getArticals());

        return orderRepo.save(ordr);
    }

    public List<Ordr> GetAllOrdesr(){
        return orderRepo.findAll();
    }


    public String GenerateRef(int byteLenght){
        SecureRandom secureRandom  = new SecureRandom();
        byte[] token = new byte[byteLenght];
        secureRandom.nextBytes(token);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(token);
    }


    public Long countOrders(){
        return orderRepo.count();
    }
}
