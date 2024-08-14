package com.techacademy.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    public static enum Gender {
        男性, 女性
    }

    /** 主キー。自動生成 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, nullable = false)
    @NotEmpty
    @Length(max = 20)
    private String name;

    @Column(length = 2)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Gender gender;

    @Min(0)
    @Max(120)
    private Integer age;

    @Column(length = 50)
    @Email
    @Length(max = 50)
    private String email;

    @OneToOne(mappedBy = "user")
    private Authentication authentication;

    @PreRemove
    @Transactional
    private void preRemove() {
        if (authentication != null) {
            authentication.setUser(null);
        }
    }

}