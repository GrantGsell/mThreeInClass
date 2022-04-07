package classroster.dao;

/**
 *
 * @author Grant
 */
public interface ClassRosterAuditDao {
    
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException;
    
}
