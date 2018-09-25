package dbservice;

import org.hibernate.Session;


public interface ExecUpdate {
    void execUpdate(Session session);
}