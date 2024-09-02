package com.upc.productsapi.complaints.model.entity;

import com.upc.productsapi.complaints.model.dto.enums.Type;
import com.upc.productsapi.street.model.dto.enums.RiskLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "complaints")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complaints {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complaintsId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer type;

    @Enumerated(EnumType.STRING)
    public Type getTypeEnum() {

        if (type == 1) {
            return Type.ROBBERY;
        }
        else if (type == 2) {
            return Type.VEHICULAR_INCIDENT;
        }
        else if (type == 3) {
            return  Type.SHOOTING;
        }
        else if (type == 4) {
            return  Type.EMERGENCY;
        }
        else {
            return null;
        }
    }

    public void setTypeEnum(Type typeEnum) {

        this.type = (typeEnum == Type.ROBBERY) ? 1 : this.type;
        this.type = (typeEnum == Type.VEHICULAR_INCIDENT) ? 2 : this.type;
        this.type = (typeEnum == Type.SHOOTING) ? 3 : this.type;
        this.type = (typeEnum == Type.EMERGENCY) ? 4 : this.type;

    }

}
