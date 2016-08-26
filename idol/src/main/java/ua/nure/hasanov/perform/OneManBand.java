package ua.nure.hasanov.perform;

import ua.nure.hasanov.stage.instrument.Instrument;

import java.util.Collection;
import java.util.Map;

public class OneManBand implements Performable {

    private Collection<Instrument> instrumentList;
    private Map<String, Instrument> instrumentMap;

    public void setInstrumentList(Collection<Instrument> instrumentList) {
        this.instrumentList = instrumentList;
    }

    public void setInstrumentMap(Map<String, Instrument> instrumentMap) {
        this.instrumentMap = instrumentMap;
    }

    @Override
    public void perform() {
        for (Instrument instrument : instrumentList) {
            instrument.play();
        }
        for (final Map.Entry<String, Instrument> instrumentEntry : instrumentMap.entrySet()) {
            System.out.print("Instrument:" + instrumentEntry.getKey() + ", ");
            instrumentEntry.getValue().play();
        }
    }

}
