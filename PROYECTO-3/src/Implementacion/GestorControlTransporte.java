package Implementacion;

import java.util.Scanner;

import Suministro.SuministroEmergencia;

public class GestorControlTransporte {
    private SuministroEmergencia[] lotes = new SuministroEmergencia[0];
    private SuministroEmergencia[] sectorAlimentos = new SuministroEmergencia[3];

    public GestorControlTransporte() {
    }

    public GestorControlTransporte(SuministroEmergencia[] lotes, SuministroEmergencia[] sectorAlimentos) {
        this.lotes = lotes;
        this.sectorAlimentos = sectorAlimentos;
    }

    public void main(String[] args){
        Scanner sc = new Scanner(System.in);
    }
    
    public void registrarLote(SuministroEmergencia lote) {
        
    }

    public void cargarDatosSemilla() {
        
    }
}
