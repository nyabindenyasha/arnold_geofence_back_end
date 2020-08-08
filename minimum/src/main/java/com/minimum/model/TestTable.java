package com.minimum.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author GustTech
 */
@Entity
@Table(name = "test_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestTable.findAll", query = "SELECT t FROM TestTable t")
    , @NamedQuery(name = "TestTable.findById", query = "SELECT t FROM TestTable t WHERE t.id = :id")
    , @NamedQuery(name = "TestTable.findByTestValue", query = "SELECT t FROM TestTable t WHERE t.testValue = :testValue")})

public class TestTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 250)
    @Column(name = "test_value")
    private String testValue;

    public TestTable() {
    }

    public TestTable(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestTable)) {
            return false;
        }
        TestTable other = (TestTable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "TestTable [id=" + id + ", testValue=" + testValue + "]";
	}  
}
