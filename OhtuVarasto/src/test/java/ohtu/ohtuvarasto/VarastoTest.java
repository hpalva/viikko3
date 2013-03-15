package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    @Test
    public void konstruktorillaNegatiivinenParametri(){
        varasto = new Varasto(-3);
        assertEquals(0, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void toisellakonstruktorillaNegatiivinenParametri(){
        varasto = new Varasto(-3,2);
        assertEquals(0, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
    @Test
    public void konstruktoriLaittaaOikeanAlkuSaldon(){
        varasto = new Varasto(10, 2); 
        assertEquals(2, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }
    
    @Test
    public void otataanEnemmanKuinVoidaan(){
        varasto.lisaaVarastoon(8);
        double saatuMaara = varasto.otaVarastosta(10);
        assertEquals(8, saatuMaara, vertailuTarkkuus);
    }
    
    @Test
    public void otataanEnemmanKuinVoidaanjaSaldoNolla(){
        varasto.lisaaVarastoon(8);
        varasto.otaVarastosta(13);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);
        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void lisataanLiikaa(){
        varasto.lisaaVarastoon(13);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    @Test
    public void otetaanNegatiivisesti(){
        varasto.lisaaVarastoon(5);
        double saatuMaara = varasto.otaVarastosta(-4);
        assertEquals(0, saatuMaara, vertailuTarkkuus);
    }
    
    @Test
    public void lisataanNegatiivisesti(){
        varasto.lisaaVarastoon(-5);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    @Test 
      public void lisataanEimitaan(){
        varasto.lisaaVarastoon(0);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test 
    public void paljonkoMahtuuToimii(){
        varasto.lisaaVarastoon(5);
        assertEquals(5, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    @Test
    public void konstr() {
        varasto = new Varasto(-1);
        varasto = new Varasto(0);
        varasto = new Varasto(1,1);
        varasto = new Varasto(1,2);
        varasto = new Varasto(-1,2);
        varasto = new Varasto(-1,-1);
        varasto.toString();
    }
}