package org.example.anoita.controler;

import javafx.event.ActionEvent;
import javafx.event.Event;
import org.example.anoita.materials.abst.Material;
import org.example.anoita.materials.liquids.Air;
import org.example.anoita.materials.liquids.Oil;
import org.example.anoita.materials.liquids.Water;
import org.example.anoita.materials.particles.Fire;
import org.example.anoita.materials.particles.GunPowder;
import org.example.anoita.materials.particles.Sand;
import org.example.anoita.materials.particles.Snow;
import org.example.anoita.materials.solid.Rock;
import org.example.anoita.materials.solid.Wood;

import java.lang.reflect.InvocationTargetException;

public class ButtonController {

    private Class<? extends Material> materialToPut;

    public Class<? extends Material> getMaterialToPut() {
        return materialToPut;
    }

    public Material getMaterial() {
        try {
            return materialToPut.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public void onTypeClick(String type) {
        materialToPut = switch (type)
        {
            case "GUN_POWDER" -> GunPowder.class;
            case "SAND" -> Sand.class;
            case "ROCK" -> Rock.class;
            case "OIL" -> Oil.class;
            case "FIRE" -> Fire.class;
            case "SNOW" -> Snow.class;
            case "WATER" -> Water.class;
            case "WOOD" -> Wood.class;
            default -> Air.class;
        };
    }

}
