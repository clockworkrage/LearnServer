package dbservice;

import org.hibernate.Session;


public interface ExecQuery<T> {
    T execQuery(Session session);
}