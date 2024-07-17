package com.irlix.web_app.dao;

import com.irlix.web_app.models.Gun;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GunDAO {
    private static int GUNS_COUNT;
    private final List<Gun> guns;

    {
        guns = new ArrayList<>();
        guns.add(new Gun(++GUNS_COUNT, "ak-47", "automate", 30));
        guns.add(new Gun(++GUNS_COUNT, "AWP", "Sniper Rifle", 10));
        guns.add(new Gun(++GUNS_COUNT, "UZI", "mini", 35));
    }

    public List<Gun> index() {
        return guns;
    }

    public Gun show(int id) {
        return guns.stream().filter(guns -> guns.getId() == id).findAny().orElse(null);
    }

    public void save(Gun gun) {
        gun.setId(++GUNS_COUNT);
        guns.add(gun);
    }

    public void change(int id, Gun gunChange) {
        Gun gunToBeChange = show(id);
        gunToBeChange.setName(gunChange.getName());
        gunToBeChange.setType(gunChange.getType());
        gunToBeChange.setBullets(gunChange.getBullets());
    }

    public void delete(int id) {
        guns.removeIf(w -> w.getId() == id);
    }
}
