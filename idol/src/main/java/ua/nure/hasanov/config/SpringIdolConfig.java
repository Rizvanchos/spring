package ua.nure.hasanov.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.nure.hasanov.juggler.BeanBagJuggler;
import ua.nure.hasanov.magic.BlackMagicBox;
import ua.nure.hasanov.magic.MagicBox;
import ua.nure.hasanov.perform.Instrumentalist;
import ua.nure.hasanov.perform.OneManBand;
import ua.nure.hasanov.perform.Performable;
import ua.nure.hasanov.perform.VirtuosoMusician;
import ua.nure.hasanov.stage.instrument.Instrument;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class SpringIdolConfig implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    public Performable duke() {
        return new BeanBagJuggler();
    }

    @Bean
    public Performable kenny() {
        Instrumentalist kenny = new Instrumentalist();
        kenny.setSong("My song number " + Math.random());
        kenny.setInstrument((Instrument) applicationContext.getBean("guitar"));

        return kenny;
    }

    @Bean
    public Performable jerry() {
        OneManBand jerry = new OneManBand();

        Instrument guitar = (Instrument) applicationContext.getBean("guitar");
        Instrument drums = (Instrument) applicationContext.getBean("drums");
        Instrument saxophone = (Instrument) applicationContext.getBean("saxophone");

        jerry.setInstrumentList(Arrays.asList(new Instrument[]{guitar, drums, saxophone}));

        Map<String, Instrument> instrumentMap = new HashMap<>();
        instrumentMap.put("Guitar", guitar);
        instrumentMap.put("Drums", drums);
        instrumentMap.put("Saxophone", saxophone);

        jerry.setInstrumentMap(instrumentMap);

        return jerry;
    }

    @Bean
    public Performable virtuoso() {
        return new VirtuosoMusician() {
            @Override
            public Instrument getInstrument() {
                return (Instrument) applicationContext.getBean("guitar");
            }
        };
    }

    @Bean
    public MagicBox magicBox() {
        return new BlackMagicBox();
    }

}
