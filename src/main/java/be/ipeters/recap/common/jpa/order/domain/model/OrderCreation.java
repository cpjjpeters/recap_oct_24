package be.ipeters.recap.common.jpa.order.domain.model;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/* carlpeters created on 22/10/2024 inside the package - be.ipeters.recap.common.jpa.order.domain.model */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreation {
    private Long id;
    @Builder.Default
    private Instant creationDate = Instant.now();
    @Builder.Default
    private Instant lastUpdate = Instant.now();
    private String documentId;


}
