package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {

    // business objects under test - aka "fixture"
    private Employee emp1;
    private Employee emp2;

    @Before
    public void setUp() {
//        emp1 = new SalariedEmployee("Marge", Date.valueOf("2002-02-02"));
//        emp2 = new SalariedEmployee("Marge", Date.valueOf("2002-02-02"));

//        emp1 = new DummyEmployee("Marge", Date.valueOf("2002-02-02"));
//        emp2 = new DummyEmployee("Marge", Date.valueOf("2002-02-02"));

        /*
        // creating an instance of an unnamed subclass; get ctor for free; extends Employee
        emp1 = new Employee("Marge", Date.valueOf("2002-02-02")) { // EmployeeTest$1.class
            @Override
            public double pay() {
                return 0;
            }

            @Override
            public double payTaxes() {
                return 0;
            }
        };
        // same thing as above, just different way to write it
        emp2 = new Employee("Marge", Date.valueOf("2002-02-02")) {
            public double pay() {return 0;}
            public double payTaxes() {return 0;}
        };
         */

        emp1 = getEmployee(); // (hover & let IntelliJ create the method)
        emp2 = getEmployee();
    }

    private Employee getEmployee() { // ctor calls the super
        return new Employee("Marge", Date.valueOf("2002-02-02")) {
            @Override
            public double pay() {
                return 0;
            }

            @Override
            public double payTaxes() {
                return 0;
            }
        };

    }

    @Test
    public void hashCode_shouldReturnSameValue_equalObjects() {
        assertEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate() {
        emp1.setName("Lisa");
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate() {
        emp2.setHireDate(Date.valueOf("2012-02-02"));
        assertNotEquals(emp1, emp2);
//        assertFalse(emp1.equals(emp2)); // would not use both (use above)
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp1, emp2); // uses equals() when objects passed in
//        assertTrue(emp1.equals(emp2)); // would not use both (use above)
    }

    // NAMED MEMBER LEVEL INNER CLASSES
    private class DummyEmployee extends Employee {
        public DummyEmployee() {
        }

        public DummyEmployee(String name, Date hireDate) {
            super(name, hireDate);
        }

        @Override
        public double pay() {
            return 0;
        }

        @Override
        public double payTaxes() {
            return 0;
        }
    }
}