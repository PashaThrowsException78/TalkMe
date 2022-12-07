package com.tabakov.talkme.domain.entity;

import com.tabakov.talkme.domain.dto.program.ActionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "actions_detail")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ActionsDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actions_detail_id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "program_id")
    private Program program;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private ActionType type;
}