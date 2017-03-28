package conceito.processamento;


public class Estado extends Cabecote{
    
    int estado;
    char leitura;
    private Fita fita;
    
    public Estado(Fita fita){
         this.fita = fita;
    }
    
    public boolean testarespaco(char s){
        if((s == ' ')||(s == '\n')){
            return true;
        }else{
            return false;
        }
    }
    public boolean testarespacoespecial(char s){
        if((s == ' ')||(s == '\n')||(s == '(') || (s=='{')||(s == ')') || (s=='}')){
            return true;
        }else{
            return false;
        }
    }
    
    public String processarEstado(String estado, char leitura){
        String result = null;
        
        switch (estado) {
            case "Q0":
                switch(leitura){
                    case '-':
                        this.addCabeca(true);
                        result = processarEstado("MINUS",this.getFita().lerFita(this.getCabeca()));
                        break;
                    case '(':
                        this.addCabeca(true);
                        result = "ABRE_PAR";
                        break;
                    case ')':
                        this.addCabeca(true);
                        result = "FECHA_PAR";
                        
                        break;
                    case '{':
                        this.addCabeca(true);
                        result = "ABRE_CHAVE";
                                
                                
                        break;
                    case '}':
                        this.addCabeca(true);
                        result = "FECHA_CHAVE";
                        
                        break;
                    case ',':
                        this.addCabeca(true);
                        result = processarEstado("VIRGULA",this.getFita().lerFita(this.getCabeca()));
                        
                        break; 
                    case ';':
                        this.addCabeca(true);
                        
                        result = "PONTO_VIRGULA";
                        
                        break;
                    case '=':
                        this.addCabeca(true);
                        result = processarEstado("RECEBE",this.getFita().lerFita(this.getCabeca()));
                        
                        break;
                    case '+':
                        this.addCabeca(true);
                        result = "SUM";
                                
                        break;
                    case '*':
                        this.addCabeca(true);
                        result = "MULT";
                                
                                
                        break; 
                    case '/':
                        this.addCabeca(true);
                        result = "DIV";
                                
                                
                        break;
                    case '>':
                        this.addCabeca(true);
                        result = processarEstado("MAIOR",this.getFita().lerFita(this.getCabeca()));
                                
                                
                        break;
                    case '<':
                        this.addCabeca(true);
                        result = processarEstado("MENOR",this.getFita().lerFita(this.getCabeca()));
                                
                                
                        break;
                    case '"':
                        this.addCabeca(true);
                        result = "ASPAS_DUPLAS";
      
                        break;
                    case 'p':
                        this.addCabeca(true);
                        result = processarEstado("Q1",this.getFita().lerFita(this.getCabeca()));
                        break; 
                    case 's':
                        this.addCabeca(true);
                        result = processarEstado("Q9",this.getFita().lerFita(this.getCabeca()));
                                
                        break;
                    case 'i':
                        this.addCabeca(true);
                        result = processarEstado("Q23",this.getFita().lerFita(this.getCabeca()));
                                
                        break;
                    case 'f':
                        this.addCabeca(true);
                        result = processarEstado("Q14",this.getFita().lerFita(this.getCabeca()));
                                
                        break;
                    case 'r':
                        this.addCabeca(true);
                        result = processarEstado("Q18",this.getFita().lerFita(this.getCabeca()));
                                
                        break; 
                    case 'e':
                        this.addCabeca(true);
                        result = processarEstado("Q24",this.getFita().lerFita(this.getCabeca()));
                                
                        break;
                    case '&':
                        this.addCabeca(true);
                        result = processarEstado("Q27",this.getFita().lerFita(this.getCabeca()));
                                
                        break;
                    case '|':
                        this.addCabeca(true);
                        result = processarEstado("Q28",this.getFita().lerFita(this.getCabeca()));
                                
                        break;
                    case '!':
                        this.addCabeca(true);
                        result = processarEstado("Q29",this.getFita().lerFita(this.getCabeca()));
                                
                        break; 
                    case 'w':
                        this.addCabeca(true);
                        result = processarEstado("Q30",this.getFita().lerFita(this.getCabeca()));
                                
                        break;
                    case 'c':
                        this.addCabeca(true);
                        result = processarEstado("Q34",this.getFita().lerFita(this.getCabeca()));
                        break;
                    case ' ':
                        this.addCabeca(true);
                        result = processarEstado("Q0",this.getFita().lerFita(this.getCabeca()));
                        break;
                    default:
                        if(Character.isAlphabetic(leitura)){
                            this.addCabeca(true);
                            result = processarEstado("IDENTIFICADOR",this.getFita().lerFita(this.getCabeca()));
                        }else if(Character.isDigit(leitura)){
                            this.addCabeca(true);
                            result = processarEstado("INT",this.getFita().lerFita(this.getCabeca()));
                        }else if(leitura == '\n'){
                            this.addCabeca(true);
                            result = "QUEBRA_LINHA";
                        }else{
                            return "CARACTER_INVALIDO";
                        }
                    
                }
                break;
            case "FLOAT":
                if(testarespaco(leitura))return "FLOAT";
                if(Character.isDigit(leitura)){
                    this.addCabeca(true);
                    result = processarEstado("FLOAT",this.getFita().lerFita(this.getCabeca()));
                }else{
                return "NAO_RECONHECIDO";
                }
                break;
            case "IDENTIFICADOR":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                if((Character.isDigit(leitura))||(Character.isAlphabetic(leitura))){
                    this.addCabeca(true);
                    result = processarEstado("IDENTIFICADOR",this.getFita().lerFita(this.getCabeca()));
                }else{
                return "CARACTER_INVALIDO";
                }
                break;
            case "INT":
                if(testarespaco(leitura))return "INT";
                if(leitura == '.'){
                        this.addCabeca(true);
                        result = processarEstado("FLOAT",this.getFita().lerFita(this.getCabeca()));
                        break;
                }else if(Character.isDigit(leitura)){
                    this.addCabeca(true);
                    result = processarEstado("INT",this.getFita().lerFita(this.getCabeca()));
                }else{
                    return "NAO_RECONHECIDO";
                }
                break;
            case "MINUS":
                if(testarespaco(leitura))return "MINUS";
                if(Character.isDigit(leitura)){
                    this.addCabeca(true);
                    result = processarEstado("INT",this.getFita().lerFita(this.getCabeca()));
                }else{
                return "MINUS";
                }
                break;
            case "MAIOR":
                if(testarespaco(leitura))return "MAIOR";
                switch(leitura){
                    case '=':
                        this.addCabeca(true);
                        result = processarEstado("MAIOR_IGUAL",this.getFita().lerFita(this.getCabeca()));
                        break;
                    case '>':
                        this.addCabeca(true);
                        result = processarEstado("MUITO_MAIOR",this.getFita().lerFita(this.getCabeca()));
                        break;
                    default: return "NAO_RECONHECIDO";
                }
                break;
            case "MENOR":
                if(testarespaco(leitura))return "MENOR";
                switch(leitura){
                    case '=':
                        this.addCabeca(true);
                        result = processarEstado("MENOR_IGUAL",this.getFita().lerFita(this.getCabeca()));
                        break;
                    case '<':
                        this.addCabeca(true);
                        result = processarEstado("MUITO_MENOR",this.getFita().lerFita(this.getCabeca()));
                        break;
                    default: return "NAO_RECONHECIDO";
                }
                break;
            case "ABRE_PAR":
                return "ABRE_PAR";

            case "PRINCIPAL":
                if(testarespacoespecial(leitura))return "PRINCIPAL";
                else{
                    this.addCabeca(true);
                    result = processarEstado("IDENTIFICADOR",this.getFita().lerFita(this.getCabeca()));
                }
                break;
            case "STRING_VAR":
                if(testarespaco(leitura))return "STRING_VAR";
                else{
                    this.addCabeca(true);
                    result = processarEstado("IDENTIFICADOR",this.getFita().lerFita(this.getCabeca()));
                }
                break;
            case "INT_VAR":
                if(testarespaco(leitura))return "INT_VAR";
                else{
                    this.addCabeca(true);
                    result = processarEstado("IDENTIFICADOR",this.getFita().lerFita(this.getCabeca()));
                }
                break;
            case "FLOAT_VAR":
                if(testarespaco(leitura))return "FLOAT_VAR";
                else{
                    this.addCabeca(true);
                    result = processarEstado("IDENTIFICADOR",this.getFita().lerFita(this.getCabeca()));
                }
                break;
            case "RETORNO":
                if(testarespaco(leitura))return "RETORNO";
                else{
                    this.addCabeca(true);
                    result = processarEstado("IDENTIFICADOR",this.getFita().lerFita(this.getCabeca()));
                }
                break;
            case "IF":
                if(testarespacoespecial(leitura))return "IF";
                else{
                    this.addCabeca(true);
                    result = processarEstado("IDENTIFICADOR",this.getFita().lerFita(this.getCabeca()));
                }
                break;
            case "ELSE":
                if(testarespaco(leitura))return "ELSE";
                else{
                    this.addCabeca(true);
                    result = processarEstado("IDENTIFICADOR",this.getFita().lerFita(this.getCabeca()));
                }
                break;
            case "VIRGULA":
                if(testarespaco(leitura))return "VIRGULA";
                else{
                    return "ESPACO_VIRGULA";
                } 
            case "RECEBE":
                switch(leitura){
                    case ' ':
                        return "RECEBE";
                        
                    case '=':
                        this.addCabeca(true);
                        result = processarEstado("IGUAL",this.getFita().lerFita(this.getCabeca()));
                        break;
                    default:
                        return "NAO_RECONHECIDO";
                }
                
                break;
            
            case "IGUAL":
                if(testarespaco(leitura))return "IGUAL";
                else{
                    return "NAO_RECONHECIDO";
                }
            case "AND":
                if(testarespaco(leitura))return "AND";
                else{
                    return "NAO_RECONHECIDO";
                }
            case "OR":
                if(testarespaco(leitura))return "OR";
                else{
                    return "NAO_RECONHECIDO";
                }
            case "DIFERENTE":
                if(testarespaco(leitura))return "DIFERENTE";
                else{
                    return "NAO_RECONHECIDO";
                }
            case "MAIOR_IGUAL":
                if(testarespaco(leitura))return "MAIOR_IGUAL";
                else{
                    return "NAO_RECONHECIDO";
                }
            case "MENOR_IGUAL":
                if(testarespaco(leitura))return "MENOR_IGUAL";
                else{
                    return "NAO_RECONHECIDO";
                }
            case "QUEBRA_LINHA":
                if(testarespaco(leitura))return "CARACTER_INVALIDO";
                else if(leitura == 'r'){
                    return "QUEBRA_LINHA";
                }else{
                    return "CARACTER_INVALIDO";
                }
            case "WHILE":
                if(testarespacoespecial(leitura))return "WHILE";
                else{
                    this.addCabeca(true);
                    result = processarEstado("IDENTIFICADOR",this.getFita().lerFita(this.getCabeca()));
                }
                break;
            case "CIN":
                if(testarespaco(leitura))return "CIN";
                else{
                    this.addCabeca(true);
                    result = processarEstado("IDENTIFICADOR",this.getFita().lerFita(this.getCabeca()));
                }
                break;
            case "COUT":
                if(testarespaco(leitura))return "COUT";
                else{
                    this.addCabeca(true);
                    result = processarEstado("IDENTIFICADOR",this.getFita().lerFita(this.getCabeca()));
                }
                break;
            case "MUITO_MAIOR":
                if(testarespaco(leitura))return "MUITO_MAIOR";
                else{
                    return "NAO_RECONHECIDO";
                }
            case "MUITO_MENOR":
                if(testarespaco(leitura))return "MUITO_MENOR";
                else{
                    return "NAO_RECONHECIDO";
                }
            case "Q1":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'r':
                        this.addCabeca(true);
                        result = processarEstado("Q2",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                if(Character.isAlphabetic(leitura)){
                    if(leitura != 'r'){
                        this.addCabeca(true);
                        result = processarEstado("IDENTIFICADOR",this.getFita().lerFita(this.getCabeca()));
                    }
                }else{
                    return "NAO_RECONHECIDO";
                }
                
                break;
            case "Q2":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'i':
                        this.addCabeca(true);
                        result = processarEstado("Q3",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;
            case "Q3":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'n':
                        this.addCabeca(true);
                        result = processarEstado("Q4",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;
            case "Q4":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'c':
                        this.addCabeca(true);
                        result = processarEstado("Q5",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;
            case "Q5":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'i':
                        this.addCabeca(true);
                        result = processarEstado("Q6",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;
            case "Q6":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'p':
                        this.addCabeca(true);
                        result = processarEstado("Q7",this.getFita().lerFita(this.getCabeca()));;
                        break;
                }
                break;
            case "Q7":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'a':
                        this.addCabeca(true);
                        result = processarEstado("Q8",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;
            case "Q8":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'l':
                        this.addCabeca(true);
                        result = processarEstado("PRINCIPAL",this.getFita().lerFita(this.getCabeca()));;
                        break;
                }
                break;
            case "Q9":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 't':
                        this.addCabeca(true);
                        result = processarEstado("Q10",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                if(Character.isAlphabetic(leitura)){
                    if(leitura != 't'){
                        this.addCabeca(true);
                        result = processarEstado("IDENTIFICADOR",this.getFita().lerFita(this.getCabeca()));
                    }
                }else{
                    return "NAO_RECONHECIDO";
                }
                break;    
            case "Q10":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'r':
                        this.addCabeca(true);
                        result = processarEstado("Q11",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;    
            case "Q11":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'i':
                        this.addCabeca(true);
                        result = processarEstado("Q12",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;    
            case "Q12":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'n':
                        this.addCabeca(true);
                        result = processarEstado("Q13",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;    
            case "Q13":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'g':
                        this.addCabeca(true);
                        result = processarEstado("STRING_VAR",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;    
            case "Q14":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'l':
                        this.addCabeca(true);
                        result = processarEstado("Q15",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;    
            case "Q15":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'o':
                        this.addCabeca(true);
                        result = processarEstado("Q16",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;    
            case "Q16":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'a':
                        this.addCabeca(true);
                        result = processarEstado("Q17",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;    
            case "Q17":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 't':
                        this.addCabeca(true);
                        result = processarEstado("FLOAT_VAR",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;    
            case "Q18":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'e':
                        this.addCabeca(true);
                        result = processarEstado("Q19",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                if(Character.isAlphabetic(leitura)){
                    if(leitura != 'e'){
                        this.addCabeca(true);
                        result = processarEstado("IDENTIFICADOR",this.getFita().lerFita(this.getCabeca()));
                    }
                }else{
                    return "NAO_RECONHECIDO";
                }
                break;    
            case "Q19":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 't':
                        this.addCabeca(true);
                        result = processarEstado("Q20",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;    
            case "Q20":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'u':
                        this.addCabeca(true);
                        result = processarEstado("Q21",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;    
            case "Q21":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'r':
                        this.addCabeca(true);
                        result = processarEstado("Q22",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;    
            case "Q22":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'n':
                        this.addCabeca(true);
                        result = processarEstado("RETORNO",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;
            case "Q23":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'f':
                        this.addCabeca(true);
                        result = processarEstado("IF",this.getFita().lerFita(this.getCabeca()));;
                        break;
                    case 'n':
                        this.addCabeca(true);
                        result = processarEstado("W21",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                if(Character.isAlphabetic(leitura)){
                    if((leitura != 'f')&&(leitura != 'n')){
                        this.addCabeca(true);
                        result = processarEstado("IDENTIFICADOR",this.getFita().lerFita(this.getCabeca()));
                    }
                }else{
                    return "NAO_RECONHECIDO";
                }
                break;
            case "W21":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 't':
                        this.addCabeca(true);
                        result = processarEstado("INT_VAR",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;    
            case "Q24":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'l':
                        this.addCabeca(true);
                        result = processarEstado("Q25",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                if(Character.isAlphabetic(leitura)){
                    if(leitura != 'l'){
                        this.addCabeca(true);
                        result = processarEstado("IDENTIFICADOR",this.getFita().lerFita(this.getCabeca()));
                    }
                }else{
                    return "NAO_RECONHECIDO";
                }
                break;    
            case "Q25":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 's':
                        this.addCabeca(true);
                        result = processarEstado("Q26",this.getFita().lerFita(this.getCabeca()));;
                        break;
                }
                break;    
            case "Q26":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'e':
                        this.addCabeca(true);
                        result = processarEstado("ELSE",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;    
            case "Q27":
                if(testarespaco(leitura))return "NAO_RECONHECIDO";
                switch(leitura){
                    case '&':
                        this.addCabeca(true);
                        result = processarEstado("AND",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;    
            case "Q28":
                if(testarespaco(leitura))return "NAO_RECONHECIDO";
                switch(leitura){
                    case '|':
                        this.addCabeca(true);
                        result = processarEstado("OR",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;    
            case "Q29":
                if(testarespaco(leitura))return "NAO_RECONHECIDO";
                switch(leitura){
                    case '=':
                        this.addCabeca(true);
                        result = processarEstado("DIFERENTE",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;    
            case "Q30":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'h':
                        this.addCabeca(true);
                        result = processarEstado("Q31",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                if(Character.isAlphabetic(leitura)){
                    if(leitura != 'h'){
                        this.addCabeca(true);
                        result = processarEstado("IDENTIFICADOR",this.getFita().lerFita(this.getCabeca()));
                    }
                }else{
                    return "NAO_RECONHECIDO";
                }
                break;    
            case "Q31":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'i':
                        this.addCabeca(true);
                        result = processarEstado("Q32",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;    
            case "Q32":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'l':
                        this.addCabeca(true);
                        result = processarEstado("Q33",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;    
            case "Q33":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'e':
                        this.addCabeca(true);
                        result = processarEstado("WHILE",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;    
            case "Q34":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'i':
                        this.addCabeca(true);
                        result = processarEstado("Q35",this.getFita().lerFita(this.getCabeca()));
                        break;
                    case 'o':
                        this.addCabeca(true);
                        result = processarEstado("Q36",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                if(Character.isAlphabetic(leitura)){
                    if((leitura != 'o')&&(leitura != 'i')){
                        this.addCabeca(true);
                        result = processarEstado("IDENTIFICADOR",this.getFita().lerFita(this.getCabeca()));
                    }
                }else{
                    return "NAO_RECONHECIDO";
                }
                break;    
            case "Q35":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'n':
                        this.addCabeca(true);
                        result = processarEstado("CIN",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;    
            case "Q36":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 'u':
                        this.addCabeca(true);
                        result = processarEstado("Q37",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;    
            case "Q37":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 't':
                        this.addCabeca(true);
                        result = processarEstado("COUT",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;
            case "Q38":
                if(testarespaco(leitura))return "IDENTIFICADOR";
                switch(leitura){
                    case 't':
                        this.addCabeca(true);
                        result = processarEstado("COUT",this.getFita().lerFita(this.getCabeca()));
                        break;
                }
                break;
            default:
                return "ERRO - ESTADO INVÁLIDO!";
        }
        return result;
    }
    
    public void realizarEstado(char c,boolean d){
        fita.escreverFita(getCabeca(), c);
        addCabeca(d);
    }
    
    public void erroEstado(int x){
        if(x == 1){
            System.out.println("Erro 01: Estado não reconhecido!");
        }else{
            System.out.println("Erro 02: Palavra não reconhecida!");
        }
    }

    public Fita getFita() {
        return fita;
    } 
   
}
