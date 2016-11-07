package com.agency.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vladimir on 01.11.2016.
 */
@Entity
@Table(name = "estate_show")
public class EstateShow {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "meeting_time")
    private Date meetingTime;
    @Column(name = "client_surname")
    private String clientSurname;
    @Column(name = "client_name")
    private String clientName;
    @Column(name = "client_patr")
    private String clientPatronymic;
    @Column(name = "client_phone")
    private String clientPhone;

    @ManyToOne(targetEntity = RealEstate.class)
    @JoinColumn(name = "estate_id")
    private RealEstate realEstate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPatronymic() {
        return clientPatronymic;
    }

    public void setClientPatronymic(String clientPatronymic) {
        this.clientPatronymic = clientPatronymic;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public RealEstate getRealEstate() {
        return realEstate;
    }

    public void setRealEstate(RealEstate realEstate) {
        this.realEstate = realEstate;
    }

    public Date getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(Date meetingTime) {
        this.meetingTime = meetingTime;
    }
}
