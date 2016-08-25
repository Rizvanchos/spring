package perform;

import stage.instrument.Instrument;

import java.util.Collection;
import java.util.Map;

public class OneManBand implements Perfomable {

    private Collection<Instrument> instrumentList;
    private Map<String, Instrument> instrumentMap;

    public void setInstrumentList(final Collection<Instrument> instrumentList) {
        this.instrumentList = instrumentList;
    }

    public void setInstrumentMap(final Map<String, Instrument> instrumentMap) {
        this.instrumentMap = instrumentMap;
    }

    public void perfom() {
        for (final Instrument instrument : instrumentList) {
            instrument.play();
        }
        for (final Map.Entry<String, Instrument> instrumentEntry : instrumentMap.entrySet()) {
            System.out.print("Instrument:" + instrumentEntry.getKey() + ", ");
            instrumentEntry.getValue().play();
        }
    }

}
