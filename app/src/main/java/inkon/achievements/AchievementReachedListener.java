package inkon.achievements;

import java.util.*;

public interface AchievementReachedListener extends EventListener
{
    
    public void achievementReached (AchievementReachedEvent ev);
    
}