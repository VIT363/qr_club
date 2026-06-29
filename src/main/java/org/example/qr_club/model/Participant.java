package org.example.qr_club.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "participants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "middle_name", length = 50)
    private String middleName;

    @OneToOne(mappedBy = "participant", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private QrCode qrCode;
}
