import accidentes.*;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.Scanner;


public class Main {
    static void menu (){
        System.out.println("Ingrese la opcion");
        System.out.println("1. Agregar marca");
        System.out.println("2. Agregar incidente");
        System.out.println("3. Agregar dueño");
        System.out.println("4. Agregar comentario");
        System.out.println("5. Agregar carro");
        System.out.println("6. Marca mas vendida");
        System.out.println("7. Marca con mas incidentes");
        System.out.println("8. Pais de origen mas comun y cuantos carros tiene");
        System.out.println("9. Incidentes de cada dueño");
        System.out.println("10. Salir");
    }

    public static void main(String[] args) {
        //todo menu y las consultas
        ArrayList<Marca> marcas = new ArrayList<>();
        ArrayList<Incidente> incidentes = new ArrayList<>();
        ArrayList<Dueno>  duenos = new ArrayList<>();
        ArrayList<Comentario> comentarios = new ArrayList<>();
        ArrayList<Carro> carros = new ArrayList<>();

        /*
        Marca marca = new Marca(1, "Ferrari", "No me acuerdo");
        Marca marca2 = new Marca(2, "Koenissg", "Italia");
        Marca marca3 = new Marca(3, "Volvo", "Venecia");
        marcas.add(marca);
        marcas.add(marca2);
        marcas.add(marca3);




        Incidente inci = new Incidente(1, "Bajando palmas", "26/07/2025", "399999");
        Incidente inc2 = new Incidente(2, "Bajando loreto", "06/07/2025", "39783");
        Incidente inc3 = new Incidente(3, "yendo a valledupar", "26/09/2012", "732878382");
        incidentes.add(inci);
        incidentes.add(inc2);
        incidentes.add(inc3);





        Dueno duenno1 = new Dueno(1, "Sebastiian", "Higuita", "399999");
        Dueno duenno2 = new Dueno(2, "Daniel", "Ovalle", "39783");
        Dueno duenno3 = new Dueno(3, "Marta", "Betancurt", "732878382");
        duenos.add(duenno1);
        duenos.add(duenno2);
        duenos.add(duenno3);



        // hacer comentarios de cada carrro
        Carro carro1 = new Carro("HPK000", "2012", 2016);
        Carro carro2 = new Carro("HPK222", "2018", 2018);
        Carro carro3 = new Carro("HPK999", "2019", 2014);
        carros.add(carro1);
        carros.add(carro2);
        carros.add(carro3);

        carro1.agregarComentario("Muy duradero", "2/7/28");
        carro2.agregarComentario("Muy malo", "12/5/28");
        carro3.agregarComentario("Muy regular", "16/0/22");










*/

        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al concesionario");
        menu();
        int opcion = Integer.parseInt(sc.nextLine());
        boolean continuar = false;





        while (!continuar){
            switch(opcion){
                case 1:
                    System.out.println("Inngrese el id de la marca");
                    long idMarca = Long.parseLong(sc.nextLine());
                    System.out.println("Ingrese el nombre de la marca");
                    String nombreMarca = sc.nextLine();
                    System.out.println("Ingrese el pais de la marca");
                    String paisMarca = sc.nextLine();
                    Marca marcos = new Marca(idMarca, nombreMarca, paisMarca);
                    marcas.add(marcos);

                    break;
                case 2:
                    System.out.println("Ingrese el codigo");
                    long codigo = Long.parseLong(sc.nextLine());
                    System.out.println("Ingrese el tipo de incidente");
                    String tipoIncidente = sc.nextLine();
                    System.out.println("Ingrese la fecha de incidente");
                    String fechaIncidente = sc.nextLine();
                    long cedulaIncidente = Long.parseLong(sc.nextLine());
                    for (int i = 0; i < duenos.size(); i++) {
                        if (duenos.get(i).getCedula() == cedulaIncidente){
                            duenos.get(i).agregarIncidente(new Incidente(codigo,tipoIncidente,fechaIncidente,duenos.get(i).getTelefono()));
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Ingrese la cedula dl dueño");
                    long cedula = Long.parseLong(sc.nextLine());
                    System.out.println("Ingrese el nombre del dueño");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese el apellido del dueño");
                    String apellido = sc.nextLine();
                    System.out.println("Ingrese el telefono del dueño");
                    String tel = sc.nextLine();
                    Dueno newDueno = new Dueno(cedula, nombre, apellido, tel);
                    duenos.add(newDueno);
                    break;
                case 4:
                    System.out.println("Ingrese el comentario");
                    String comentario = sc.nextLine();
                    System.out.println("Ingrese la placa del comentario");
                    String placa = sc.nextLine();
                    System.out.println("Ingrese la fecha del comentario");
                    String fecha = sc.nextLine();
                    for (int i = 0; i < marcas.size(); i++) {
                        for (int j = 0; j < marcas.get(i).getCarros().size(); j++) {
                            if (marcas.get(i).getCarros().get(j).getPlaca().equals(placa)) {
                                marcas.get(i).getCarros().get(j).agregarComentario(comentario, fecha);
                                break;
                            }
                        }
                    }

                case 5:
                    System.out.println("Ingrese la placa del carro");
                    String placaCarro = sc.nextLine();
                    System.out.println("Ingrese el modelo del carro");
                    String modelo = sc.nextLine();
                    System.out.println("Ingrese el año de lanzamiento del carro");
                    int año = Integer.parseInt(sc.nextLine());
                    System.out.println("Marca, proporcione el id de la marca:");
                    long idMarcaCar = Long.parseLong(sc.nextLine());
                    for (int i = 0; i < marcas.size(); i++) {
                        if(marcas.get(i).getId() == idMarcaCar){
                            marcas.get(i).agregarCarro(new Carro(placaCarro,modelo,año));
                        }
                    }
                    break;
                case 6:
                    Marca mejor = null;
                    int maxCarros = 0;
                    for (Marca m : marcas) {
                        if (m.getCarros().size() > maxCarros) {
                            maxCarros = m.getCarros().size();
                            mejor = m;
                        }
                    }
                    if (mejor != null) {
                        System.out.println("La marca más vendida es: " + mejor.getNombre());
                    }
                    break;
                case 7:
                    int[] incidentessss= new int[marcas.size()];
                    for (int i=0; i<marcas.size(); i++) {
                        int ac =0;
                        for (int j=0; j<marcas.get(i).getCarros().size(); j++) {
                            //int ac =0;
                            for (int l=0; l<marcas.get(i).getCarros().get(j).getDuenos().size(); l++) {
                                ac+=marcas.get(i).getCarros().get(j).getDuenos().get(l).getIncidentes().size();
                            }
                        } // si me hubieran dicho desde el principio que era bases de datos pro max me rendia mas :(
                        incidentessss[i] = ac;
                    }
                    for (int i = 0; i < incidentessss.length; i++) {
                        System.out.println(incidentessss[i]);
                    }


                    break;
                case 8:
                    String paisMasComun = null;
                    int max = 0;
                    for (int i = 0; i < marcas.size(); i++) {
                        int total = 0;
                        for (int j = 0; j < marcas.size(); j++) {
                            if (marcas.get(j).getPais().equals(marcas.get(i).getPais())) {
                                total += marcas.get(j).getCarros().size();
                            }
                        }
                        if (total > max) {
                            max = total;
                            paisMasComun = marcas.get(i).getPais();
                        }
                    }
                    if (paisMasComun != null) {
                        System.out.println("El país de origen más común es: " + paisMasComun);
                    }
                    break;
                case 9:
                    if (!duenos.isEmpty()) {// intelij me lo recomendo y queda mas bonito :)
                        for (int i = 0; i < duenos.size(); i++) {
                            if (!duenos.get(i).getIncidentes().isEmpty()) { // intelij me lo recomendo y queda mas bonito :) X2
                                System.out.println(duenos.get(i).mostrarIncidentes());
                            }
                            else {
                                System.out.println("El dueño" + duenos.get(i).getNombre() + "todavia no se ha estallado");
                            }
                        }
                    }
                    break;
                case 10:
                    continuar = true;
                    System.out.println("La mala pa");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ingrese una de las opciones aguevado");
                    break;

            }
            menu();
            opcion = Integer.parseInt(sc.nextLine());
        }




    }
}
