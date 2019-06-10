package com.zero2one.products.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "produto")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ApiModel("ProdutoDesafio")
public class Produto {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    @Column(name = "id")
    @ApiModelProperty("Identificador")
    private Integer id;


    @Column(name = "name")
    @ApiModelProperty("Nome do produto")
    private String name;

    @Column(name = "qtd")
    @ApiModelProperty("Quantidade")
    private Integer qtd;

    @Column(name = "created_at")
    @ApiModelProperty("Data de Criação")
    private Date created_at;

    @Column(name = "updated_at")
    @ApiModelProperty("Data de Atualização")
    private Date updated_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
