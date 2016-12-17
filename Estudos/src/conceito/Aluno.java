package conceito;

public class Aluno extends Pessoa{
    private float nota1;
    private float nota2;
    private float nota3;
    
    public Aluno(String nome,int idade, Sexo sexo,float n1,float n2,float n3){
        super(nome,idade,sexo);
        this.nota1 = n1;
        this.nota2 = n2;
        this.nota3 = n3;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }
    
    public float mediaAluno(){
        return (this.getNota1()+this.getNota2()+this.getNota3())/3;
    }
    
    public String aprovado(){
        if(mediaAluno() > 6.0f){
            if(this.sexo == Sexo.MASCULINO){
                return ("O aluno "+this.nome+" foi APROVADO.");
            }else{
                return ("A aluna "+this.nome+" foi APROVADA.");
            }
        }else{
            if(this.sexo == Sexo.MASCULINO){
                return ("O aluno "+this.nome+" foi REPROVADO.");
            }else{
                return ("A aluna "+this.nome+" foi REPROVADA.");
            }
        }
    }
}
