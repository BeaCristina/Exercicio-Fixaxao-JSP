/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author beatriz
 */
public class Questoes {
    public String quest2(int num1, int num2){
        String str= "<table><caption>Tabuada<caption>"+
                "<thead><tr><th>x1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>9</th><th>10</th></thead><tbody>";
        for(int i=num1; i<=num2; i++){
            str+="<tr><th>"+i+"</th>";
            for(int j=2; j<11; j++){
                str+="<td>"+(i*j)+"</td>";
            }
            str+= "</tr>";
        }
        str+="</tbody></table>";
        return  str;
    }
    
    public String quest3(int inteiro){
        boolean triangular = false;
        String str= "<h3 class='quest2'>O numero "+inteiro+":</h3><ol type='a' class='quest2'><li>Eh ";
        str+= inteiro%2==0?"par":"impar";str+="</li><li>Eh ";
        str+= inteiro>=0?"positivo":"negativo";str+="</li><li>Eh ";
        str+= inteiro==10?"igual a":inteiro>10?"maior que":"menor que";str+=" 10</li><li>";
        str+= (inteiro%2==0||inteiro%3==0||inteiro%5==0||inteiro%7==0||inteiro%11==0)
                &&!(inteiro==2||inteiro==3||inteiro==5||inteiro==7||inteiro==11)
                ?"Nao eh":"Eh";str+=" primo</li><li>";
                
        for(int i=1, j=0, k=0; i<inteiro; i++){
            if(inteiro%i==0)
                j+=i;
            if(i==inteiro-1){
                str+=j==inteiro?"Eh":"Nao eh";
            }
            k+=i;
            if(k==inteiro)
                triangular =true;
        }        
        str+=" perfeito</li><li>";
        str+=triangular?"Eh":"Nao eh";str+=" triangular</li><li>";
        str+= (inteiro%400==0) || ((inteiro%4==0) && (inteiro%100!=0))?"Eh":"Nao eh";str+=" bissexto</li><li>";
        for(int i=inteiro-1, j=i+1; i>1; i--){
            j*=i;
            if(i==2){
                str+="Seu fatorial eh: "+j+"</li><li>";
            }
        }
        for(int i=0, j=1, k=0, l=1; i<inteiro; i++){
            l=k;
            k+=j;
            j=l;
            if(i==inteiro-1)
                str+="O "+inteiro+"&ordm; numero na sequencia de fibonnacci eh: "+k+"</li>";
        }
        str+="</ol>";
        return  str;
   
    }
    
    public String quest4(String nums){
        String str = "<h3 class='quest3'>Sequencia:</h3><h4 class='quest3'>"+nums.split(",")[0]+"";
        ArrayList<Integer[]> numeros = new ArrayList<Integer[]>();//ArrayList dos numeros
        int tam = nums.split(",").length;//Quantidade de numeros
        int menor = Integer.parseInt(nums.split(",")[0]);//menor numero
        numeros.add(new Integer[]{menor, 1});//salva o primeiro numero no List
        int maior = menor;//Maior numero
        Float media = Float.valueOf(menor);//media
        int[] mediana = new int[]{0, 0};//mediana
        String moda = "";//moda
        int ocorrencia = 0;//maior ocorrencia de valores
     
        
        //percorre todos o numeros
        for(int i=1; i<tam; i++){
            //Salva valor em num
            int num =  Integer.parseInt(nums.split(",")[i]);
            //soma todos os valores
            media +=num;
            //salva valores maiores e menores
            if(num>maior)
                maior = num;
            else if(num<menor)
                menor =num;
            str+=", "+nums.split(",")[i];
            
            //salva no arrayList caso seja repetido ele soma a ocorrencia
            boolean salvou = false;
            for(Integer[] n: numeros){
                //Adiciona ocorrencia caso seja igual e verifica o maior caso de ocorrencia
                if(n[0]==num){
                    n[1]++;
                    if(n[1]>ocorrencia)
                        ocorrencia = n[1];
                    salvou=true; 
                }
            }
            //Adiciona caso jah nao tenha sido
            if(!salvou)
                numeros.add(new Integer[]{num, 1});
        }
        //ordena o arraylist
        Collections.sort (numeros, new Comparator() {
            public int compare(Object o1, Object o2) {
                Integer[] p1 = (Integer[]) o1;
                Integer[] p2 = (Integer[]) o2;
                return p1[0] < p2[0] ? -1 : (p1[0] > p2[0] ? +1 : 0);
            }
        });
        
        
        int meio = tam/2;
        if(!(tam%2==0))
            meio++;
        int aux=0;
        int pos = 0;
        for(Integer[] n: numeros){
            aux+=n[1];
            if(aux==meio&&mediana[0]==0){
                mediana[0]=mediana[1]=n[0];
                if(tam%2==0){
                    mediana[1]=numeros.get(pos+1)[0];
                }
            } else if (aux > meio&&mediana[0]==0)
                mediana[0]=mediana[1]=n[0];
            if(n[1]==ocorrencia){
                if(moda!="")
                    moda+=", ";
                moda+=n[0];
            }
            pos++;
        }
        str += "</h4><ol type='a' class='quest3'><li>Media: <span class='quest3'>"+media/2+"</span></li>";
        str += "<li>Mediana: <span class='quest3'>"+(Float.valueOf(mediana[0]+mediana[1])/2)+"</span></li>";
        str += "<li>Moda: <span class='quest3'>"+moda+"</span></li>";
        str += "<li>Maior valor: <span class='quest3'>"+maior+"</span></li>";
        str += "<li>Menor valor: <span class='quest3'>"+menor+"</span></li></ol>";
        return str;
    }
    
    public String quest5(String nome){
        /*          Tabela de Pitagoras      */
        String str="";
        String saida ="<h2 class='quest4'>"+nome+"</h2><h6 class='quest4 legenda'>";
        int tam = nome.length();
        nome = nome.toLowerCase();
        for(int i=0, aux=0; i<tam; i++){
            char letra = nome.charAt(i);
            switch (letra){
                case 'a':
                case 'j':
                case 's':
                    str+="1";
                    saida +="1";
                    break;
                case 'b':
                case 'k':
                case 't':
                    str+="2";
                    saida +="2";
                    break;
                case 'c':
                case 'l':
                case 'u':
                    str+="3";
                    saida +="3";
                    break;
                case 'd':
                case 'm':
                case 'v':
                    str+="4";
                    saida +="4";
                    break;
                case 'e':
                case 'n':
                case 'w':
                    str+="5";
                    saida +="5";
                    break;
                case 'f':
                case 'o':
                case 'x':
                    str+="6";
                    saida +="6";
                    break;
                case 'g':
                case 'p':
                case 'y':
                    str+="7";
                    saida +="7";
                    break;
                case 'h':
                case 'q':
                case 'z':
                    str+="8";
                    //saida +="8";
                    saida +="8";
                    break;
                case 'i':
                case 'r':
                    str+="9";
                    saida +="9";
                    break;
                default:
                    saida += "&nbsp;";
            }
            saida +=" ";
            
        }
        saida +="</h6><ul class='quest4'>";
        tam = str.length();
       //percorre str e vai somando seus numeros, ate ele serem so um caractere
       for(int i=tam, sum=0, cont=0; !(i==1); i=tam){
            if((str.equals("11")||str.equals("22")||str.equals("33"))&&sum==0)
                break;
            saida+=cont==0?"<li>":"";
                cont++;
            sum += str.charAt(0)-48;
            saida += str.charAt(0)+ " + ";
            str = str.substring(1, tam);
            tam = str.length();
            if(tam==1){
                sum += str.charAt(0)-48;
                saida += str.charAt(0)+" = <span class='quest4 bolder'> "+sum+"</span></li>";
                str = String.valueOf(sum);
                tam = str.length();
                saida+= tam>1&&sum!=11&&sum!=22&&sum!=33?"<li>":"";
                sum=0;
            }
       }
       saida+="</ul><p class='quest4'><span class='border'>Tabela de Pitagoras eh: <span class='quest4 bolder red'>"+str+"</span></span></p>";
        /*      Paralindromo     */
        tam = nome.length();
        boolean paralindromo = true;
        for(int i=0, aux=tam-1; i<tam; i++, aux--){
            //ignora os espacos em branco
            while(nome.charAt(i)==' '||nome.charAt(aux)==' '){
                if(nome.charAt(i)==' ')
                    i++;
                if(nome.charAt(aux)==' ')
                    aux--;
            }
            if(nome.charAt(i)!=nome.charAt(aux)){
                paralindromo = false;
                break;
            }
        }
        saida+="<h4 class='quest4'><span class='border quest4'>";
        saida += paralindromo?"Eh":"Nao eh";
        saida +=" um paralindromo</span></h4>";
        return saida;
    }
    
    public String quest6(String voto, int[] votos){
        String saida = "<table class='quest6'><caption>Enquete</caption><thead><tr><th>Disciplina</th><th>Percentual</th><th>Votos</th><tr>"+
            "</thead><tbody>";
        String[] disciplina = {"Sistema Operacional", "Sistemas Distribuidos","Desenvolvimento Web 2","Metodologia Cientifica Aplicada",
            "Processos de Desenvolvimento de Software", "Gerencia de Configuracao de Mudanca", "Padrões de Projeto Orientado a Objetos"};
        switch (voto){
            case "so":
                votos[0]++;
                votos[7]++;
                break;
            case "sd":
                votos[1]++;
                votos[7]++;
                break;
            case "dw2":
                votos[2]++;
                votos[7]++;
                break;
            case "mca":
                votos[3]++;
                votos[7]++;
                break;
            case "pds":
                votos[4]++;
                votos[7]++;
                break;
            case "gcm":
                votos[5]++;
                votos[7]++;
                break;
            case "ppsoo":
                votos[6]++;
                votos[7]++;
                break;
        }
        for(int i= 0; i<7; i++){
            try{
                saida+="<tr><th>"+disciplina[i]+"</th><td>"+(votos[i]*100/votos[7])+"%</td><td>"+votos[i]+"</td></tr>";
            } catch (java.lang.ArithmeticException e){
            saida+="<tr><th>"+disciplina[i]+"</th><td>"+0+"%</td><td>"+votos[i]+"</td></tr>";
            }
        }
        saida += "<tr><th>Total</th><td colspan='2'>"+votos[7]+"</td></tr></tbody></table>";

        return saida;
    }
    
    public String quest7(float m, float t, int i, float p){
        //Montante = Principal . (1 + taxa) prazo
        String saida = "<table class='quest6'><caption>Investimento</caption><thead>"
                + "<tr><th>Mês</th><th>Aporte</th><th>Juros</th><th>Montante</th><tr>"+
            "</thead><tbody>";
        float aporte=m, juros=0, montante=m;
        saida += "<tr><td>Mês "+0+"</td><td>"+aporte+"</td><td>"+juros+"</td><td>"+montante+"</td><tr>";
        juros=(aporte*t)/100;aporte+=p; montante=aporte+juros;
        for(int j=1; j<=i; j++, juros+=(((aporte)*t)/100), aporte+=p, montante=aporte+juros){
            saida += "<tr><td>Mês "+j+"</td><td>"+aporte+"</td><td>"+juros+"</td><td>"+montante+"</td><tr>";
        }
        saida+="</tbody></table>";
        return saida.replace(".", ",");
    }
}

    
