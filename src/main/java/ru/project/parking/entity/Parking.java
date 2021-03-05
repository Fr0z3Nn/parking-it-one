package ru.project.parking.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String carNumber;
    boolean isFree;
}
