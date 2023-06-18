package com.group05.abstractbusiness.modules.model.Person;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.group05.abstractbusiness.modules.model.Stock.StockDigital;
import com.group05.abstractbusiness.modules.model.Stock.StockFisico;
import com.group05.abstractbusiness.modules.model.Stock.StockIntelectual;
import com.group05.abstractbusiness.utils.Validator.ValidPassword;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user_tb")
@NoArgsConstructor
public class User extends IPerson{

    @Column(name = "password", nullable = false)              
    @ValidPassword
    private String password;

    @JsonManagedReference
    @OneToMany(targetEntity = StockFisico.class, mappedBy = "user_SF", cascade = CascadeType.ALL)
    private List<StockFisico> stockFisicos;

    @JsonManagedReference
    @OneToMany(targetEntity = StockDigital.class, mappedBy = "user_SD", cascade = CascadeType.ALL)
    private List<StockDigital> stockDigitais;

    @JsonManagedReference
    @OneToMany(targetEntity = StockIntelectual.class, mappedBy = "user_SI", cascade = CascadeType.ALL)
    private List<StockIntelectual> stockIntelectuais;

    @JsonManagedReference
    @OneToMany(targetEntity = Supplier.class, mappedBy = "user_supplier", cascade = CascadeType.ALL)
    private List<Supplier> suppliers;

    @JsonManagedReference
    @OneToMany(targetEntity = Customer.class, mappedBy = "user_customer", cascade = CascadeType.ALL)
    private List<Customer> customers;

    public User(UUID id, String name, String email, LocalDate registerDate, String password,
            List<StockFisico> stockFisicos, List<StockDigital> stockDigitais, List<StockIntelectual> stockIntelectuais,
            List<Supplier> suppliers) {
        super(id, name, email, registerDate);
        this.password = password;
        this.stockFisicos = stockFisicos;
        this.stockDigitais = stockDigitais;
        this.stockIntelectuais = stockIntelectuais;
        this.suppliers = suppliers;
    }

}
