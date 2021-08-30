import Entity.EmployeeEntity;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            // SQL Dialects
            Query countEmpByDept = entityManager.createNativeQuery("SELECT COUNT(*) FROM demo.Employee INNER JOIN demo.Department D ON Employee.department_id = D.id WHERE D.name = :deptName");
            countEmpByDept.setParameter("deptName", "Encasa");
            System.out.println("There are " + countEmpByDept.getSingleResult() + " Encasa.");

              // Named Query
//            TypedQuery<EmployeeEntity> empByDeptQuery = entityManager.createNamedQuery("Employee.byDept", EmployeeEntity.class);
//            empByDeptQuery.setParameter(1, "Encasa");
//            for (EmployeeEntity employee : empByDeptQuery.getResultList()) {
//                System.out.println(employee);
//            }

//            EmployeeEntity employeeEntity = new EmployeeEntity();
//            employeeEntity.setId(6);
//            employeeEntity.setFirstName("Mulan");
//            employeeEntity.setLastName("Hua");
//            entityManager.persist(employeeEntity);

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
