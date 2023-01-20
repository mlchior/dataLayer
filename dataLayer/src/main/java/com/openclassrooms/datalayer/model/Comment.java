package com.openclassrooms.datalayer.model;

import jakarta.persistence.*;

@Entity
@Table (name = "commentaire")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentaire_id")
    private int commentaireId;
    @Column(name = "contenu")
    private String content;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "produit_id")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCommentaireId() {
        return commentaireId;
    }

    public void setCommentaireId(int commentaireId) {
        this.commentaireId = commentaireId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
