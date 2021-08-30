package Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Employee_Department", schema = "demo", catalog = "")
public class EmployeeDepartmentEntity {
    private int id;
    private EmployeeEntity employeeByEmpId;
    private DepartmentEntity departmentByDepId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDepartmentEntity that = (EmployeeDepartmentEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    public Entity.EmployeeEntity getEmployeeByEmpId() {
        return employeeByEmpId;
    }

    public void setEmployeeByEmpId(Entity.EmployeeEntity employeeByEmpId) {
        this.employeeByEmpId = employeeByEmpId;
    }

    @ManyToOne
    @JoinColumn(name = "dep_id", referencedColumnName = "id")
    public Entity.DepartmentEntity getDepartmentByDepId() {
        return departmentByDepId;
    }

    public void setDepartmentByDepId(Entity.DepartmentEntity departmentByDepId) {
        this.departmentByDepId = departmentByDepId;
    }
}
