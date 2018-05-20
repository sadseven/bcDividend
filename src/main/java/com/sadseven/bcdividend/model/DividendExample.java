package com.sadseven.bcdividend.model;

import java.util.ArrayList;
import java.util.List;

public class DividendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DividendExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("_id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("_id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("_id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("_id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("_id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("_id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("_id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("_id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("_id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("_id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("_id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("_id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCrtimeIsNull() {
            addCriterion("crtime is null");
            return (Criteria) this;
        }

        public Criteria andCrtimeIsNotNull() {
            addCriterion("crtime is not null");
            return (Criteria) this;
        }

        public Criteria andCrtimeEqualTo(Long value) {
            addCriterion("crtime =", value, "crtime");
            return (Criteria) this;
        }

        public Criteria andCrtimeNotEqualTo(Long value) {
            addCriterion("crtime <>", value, "crtime");
            return (Criteria) this;
        }

        public Criteria andCrtimeGreaterThan(Long value) {
            addCriterion("crtime >", value, "crtime");
            return (Criteria) this;
        }

        public Criteria andCrtimeGreaterThanOrEqualTo(Long value) {
            addCriterion("crtime >=", value, "crtime");
            return (Criteria) this;
        }

        public Criteria andCrtimeLessThan(Long value) {
            addCriterion("crtime <", value, "crtime");
            return (Criteria) this;
        }

        public Criteria andCrtimeLessThanOrEqualTo(Long value) {
            addCriterion("crtime <=", value, "crtime");
            return (Criteria) this;
        }

        public Criteria andCrtimeIn(List<Long> values) {
            addCriterion("crtime in", values, "crtime");
            return (Criteria) this;
        }

        public Criteria andCrtimeNotIn(List<Long> values) {
            addCriterion("crtime not in", values, "crtime");
            return (Criteria) this;
        }

        public Criteria andCrtimeBetween(Long value1, Long value2) {
            addCriterion("crtime between", value1, value2, "crtime");
            return (Criteria) this;
        }

        public Criteria andCrtimeNotBetween(Long value1, Long value2) {
            addCriterion("crtime not between", value1, value2, "crtime");
            return (Criteria) this;
        }

        public Criteria andChtimeIsNull() {
            addCriterion("chtime is null");
            return (Criteria) this;
        }

        public Criteria andChtimeIsNotNull() {
            addCriterion("chtime is not null");
            return (Criteria) this;
        }

        public Criteria andChtimeEqualTo(Long value) {
            addCriterion("chtime =", value, "chtime");
            return (Criteria) this;
        }

        public Criteria andChtimeNotEqualTo(Long value) {
            addCriterion("chtime <>", value, "chtime");
            return (Criteria) this;
        }

        public Criteria andChtimeGreaterThan(Long value) {
            addCriterion("chtime >", value, "chtime");
            return (Criteria) this;
        }

        public Criteria andChtimeGreaterThanOrEqualTo(Long value) {
            addCriterion("chtime >=", value, "chtime");
            return (Criteria) this;
        }

        public Criteria andChtimeLessThan(Long value) {
            addCriterion("chtime <", value, "chtime");
            return (Criteria) this;
        }

        public Criteria andChtimeLessThanOrEqualTo(Long value) {
            addCriterion("chtime <=", value, "chtime");
            return (Criteria) this;
        }

        public Criteria andChtimeIn(List<Long> values) {
            addCriterion("chtime in", values, "chtime");
            return (Criteria) this;
        }

        public Criteria andChtimeNotIn(List<Long> values) {
            addCriterion("chtime not in", values, "chtime");
            return (Criteria) this;
        }

        public Criteria andChtimeBetween(Long value1, Long value2) {
            addCriterion("chtime between", value1, value2, "chtime");
            return (Criteria) this;
        }

        public Criteria andChtimeNotBetween(Long value1, Long value2) {
            addCriterion("chtime not between", value1, value2, "chtime");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Long value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Long value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Long value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Long value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Long value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Long> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Long> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Long value1, Long value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Long value1, Long value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTurnoverIsNull() {
            addCriterion("turnover is null");
            return (Criteria) this;
        }

        public Criteria andTurnoverIsNotNull() {
            addCriterion("turnover is not null");
            return (Criteria) this;
        }

        public Criteria andTurnoverEqualTo(Double value) {
            addCriterion("turnover =", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverNotEqualTo(Double value) {
            addCriterion("turnover <>", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverGreaterThan(Double value) {
            addCriterion("turnover >", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverGreaterThanOrEqualTo(Double value) {
            addCriterion("turnover >=", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverLessThan(Double value) {
            addCriterion("turnover <", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverLessThanOrEqualTo(Double value) {
            addCriterion("turnover <=", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverIn(List<Double> values) {
            addCriterion("turnover in", values, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverNotIn(List<Double> values) {
            addCriterion("turnover not in", values, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverBetween(Double value1, Double value2) {
            addCriterion("turnover between", value1, value2, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverNotBetween(Double value1, Double value2) {
            addCriterion("turnover not between", value1, value2, "turnover");
            return (Criteria) this;
        }

        public Criteria andSinglecostIsNull() {
            addCriterion("singleCost is null");
            return (Criteria) this;
        }

        public Criteria andSinglecostIsNotNull() {
            addCriterion("singleCost is not null");
            return (Criteria) this;
        }

        public Criteria andSinglecostEqualTo(Double value) {
            addCriterion("singleCost =", value, "singlecost");
            return (Criteria) this;
        }

        public Criteria andSinglecostNotEqualTo(Double value) {
            addCriterion("singleCost <>", value, "singlecost");
            return (Criteria) this;
        }

        public Criteria andSinglecostGreaterThan(Double value) {
            addCriterion("singleCost >", value, "singlecost");
            return (Criteria) this;
        }

        public Criteria andSinglecostGreaterThanOrEqualTo(Double value) {
            addCriterion("singleCost >=", value, "singlecost");
            return (Criteria) this;
        }

        public Criteria andSinglecostLessThan(Double value) {
            addCriterion("singleCost <", value, "singlecost");
            return (Criteria) this;
        }

        public Criteria andSinglecostLessThanOrEqualTo(Double value) {
            addCriterion("singleCost <=", value, "singlecost");
            return (Criteria) this;
        }

        public Criteria andSinglecostIn(List<Double> values) {
            addCriterion("singleCost in", values, "singlecost");
            return (Criteria) this;
        }

        public Criteria andSinglecostNotIn(List<Double> values) {
            addCriterion("singleCost not in", values, "singlecost");
            return (Criteria) this;
        }

        public Criteria andSinglecostBetween(Double value1, Double value2) {
            addCriterion("singleCost between", value1, value2, "singlecost");
            return (Criteria) this;
        }

        public Criteria andSinglecostNotBetween(Double value1, Double value2) {
            addCriterion("singleCost not between", value1, value2, "singlecost");
            return (Criteria) this;
        }

        public Criteria andDoublecostIsNull() {
            addCriterion("doubleCost is null");
            return (Criteria) this;
        }

        public Criteria andDoublecostIsNotNull() {
            addCriterion("doubleCost is not null");
            return (Criteria) this;
        }

        public Criteria andDoublecostEqualTo(Double value) {
            addCriterion("doubleCost =", value, "doublecost");
            return (Criteria) this;
        }

        public Criteria andDoublecostNotEqualTo(Double value) {
            addCriterion("doubleCost <>", value, "doublecost");
            return (Criteria) this;
        }

        public Criteria andDoublecostGreaterThan(Double value) {
            addCriterion("doubleCost >", value, "doublecost");
            return (Criteria) this;
        }

        public Criteria andDoublecostGreaterThanOrEqualTo(Double value) {
            addCriterion("doubleCost >=", value, "doublecost");
            return (Criteria) this;
        }

        public Criteria andDoublecostLessThan(Double value) {
            addCriterion("doubleCost <", value, "doublecost");
            return (Criteria) this;
        }

        public Criteria andDoublecostLessThanOrEqualTo(Double value) {
            addCriterion("doubleCost <=", value, "doublecost");
            return (Criteria) this;
        }

        public Criteria andDoublecostIn(List<Double> values) {
            addCriterion("doubleCost in", values, "doublecost");
            return (Criteria) this;
        }

        public Criteria andDoublecostNotIn(List<Double> values) {
            addCriterion("doubleCost not in", values, "doublecost");
            return (Criteria) this;
        }

        public Criteria andDoublecostBetween(Double value1, Double value2) {
            addCriterion("doubleCost between", value1, value2, "doublecost");
            return (Criteria) this;
        }

        public Criteria andDoublecostNotBetween(Double value1, Double value2) {
            addCriterion("doubleCost not between", value1, value2, "doublecost");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}