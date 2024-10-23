package be.ipeters.recap.common.jpa.order.persistance.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

/* carlpeters created on 22/10/2024 inside the package - be.ipeters.recap.common.jpa.order.persistance.jpa */
@Table(name = "ORDERCREATION")
@Entity
//@EntityListeners(OrderCreationJpaEntityListener.class)
public class OrderCreationJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long documentId;

    @CreatedDate
    @Column(name = "CREATION_DATE", updatable = false)
    protected Instant creationDate;

    @LastModifiedDate
    @Column(name = "LAST_UPDATE")
    protected Instant lastUpdate;
}
