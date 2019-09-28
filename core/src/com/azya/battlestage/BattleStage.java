package com.azya.battlestage;

import com.azya.models.EnemyModel;
import com.azya.models.HeroModel;

import java.util.Map;
public class BattleStage {
    private Map<BattlePosition, EnemyModel> enemies;
    private Map<BattlePosition, HeroModel> foos;
    public Map<BattlePosition, EnemyModel> getEnemies() {
        return enemies;
    }
    public Map<BattlePosition, HeroModel> getFoos() {
        return foos;
    }
}
