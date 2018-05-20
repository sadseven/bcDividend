package com.sadseven.bcdividend.model;

public class Dividend {
    private Integer id;

    private Long crtime;

    private Long chtime;

    private Long time;

    private Double turnover;

    private Double singlecost;

    private Double doublecost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCrtime() {
        return crtime;
    }

    public void setCrtime(Long crtime) {
        this.crtime = crtime;
    }

    public Long getChtime() {
        return chtime;
    }

    public void setChtime(Long chtime) {
        this.chtime = chtime;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    public Double getSinglecost() {
        return singlecost;
    }

    public void setSinglecost(Double singlecost) {
        this.singlecost = singlecost;
    }

    public Double getDoublecost() {
        return doublecost;
    }

    public void setDoublecost(Double doublecost) {
        this.doublecost = doublecost;
    }
}