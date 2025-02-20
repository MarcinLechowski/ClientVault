package Kaer.com.clientTools;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Size(min = 5, message = "Nazwa musi mieć co najmniej 5 znaków")
    private String name;

    private String country;
    private String goodsHeBuy;
    private String goodsHeSell;
    private double creditLimit;
//    private double acceptedPrice;
//    private double offeredPrice;
    private String contact;
    private String info;

    public void updateFrom(Client other) {
        this.name = other.getName();
        this.country = other.getCountry();
        this.goodsHeBuy = other.getGoodsHeBuy();
        this.goodsHeSell = other.getGoodsHeSell();
        this.creditLimit = other.getCreditLimit();
//        this.acceptedPrice = other.getAcceptedPrice();
//        this.offeredPrice = other.getOfferedPrice();
        this.contact = other.getContact();
        this.info = other.getInfo();
    }
}

