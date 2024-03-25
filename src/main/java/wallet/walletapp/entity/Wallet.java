package wallet.walletapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @NotBlank(message = "Name cann't be blank")
    @Size(min = 2,max = 30)
    public String name;
    @Size(min = 2,max = 30)
    public String accountNumber;
    @Size(max = 100)
    public String description;
    @Min(1)
    @Max(3)
    public Integer priority; //1=High; 2=Medium; 3=Low
    public Double currentBalance;
    @PrePersist
    public void setBalance(){ this.currentBalance = Double.valueOf(0.0); }
     
    public Long setId(Long id) {
        return id;
    }
    
    public Long getId() {
        return id;
    }

}