package com.example.demo.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatePop {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	private String state;
	private Integer year;
	private Long population;
}
