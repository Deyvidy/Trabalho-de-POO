package model;

/**
 *
 * @author Deyvidy
 */

public class Id {
    private static int IdEscola = 1;
    private static int IdSetor = 1;
    private static int IdAluno = 1;
    private static int IdAdm = 1;
    private static int IdProfessor = 1;
    private static int IdDisciplina = 1;
    private static int IdTurma = 1;
    private static int IdCurso = 1;
    
    public static int getIdEscola() {
        return IdEscola++;
    }
    public static int getIdSetor() {
        return IdSetor++;
    }
    public static int getIdAluno() {
        return IdAluno++;
    }
    public static int getIdAdministrativo() {
        return IdAdm++;
    }
    public static int getIdProfessor() {
        return IdProfessor++;
    }
    public static int getIdDisciplina() {
        return IdDisciplina++;
    }
    public static int getIdTurmas() {
        return IdTurma++;
    }
    public static int getIdCurso() {
        return IdCurso++;
    }
    
    
}
