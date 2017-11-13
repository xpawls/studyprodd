package java23.jdbc;

public interface IServiceAuth extends IAuth {
    public int transCommit(ModelAuth a1, ModelAuth a2);
    public int transRollback(ModelAuth a1, ModelAuth a2);
}
