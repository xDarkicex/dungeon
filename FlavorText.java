public class FlavorText {
  public static final String[] story_pieces = new String[]{
    "You take a step into the Dungeon...",
    "You follow the the cold winds, deeper into the dungeon.",
    "A spider crosses your path, you change directions",
    "The wind is colder down here!",
    "You hear shrieking in the background.",
    "Mist gathers at your feet",
    "You settle down for the night",
    "You lamp is running out of oil",
    "A chill rattles your bones as you gasp for breath waking from a night terror",
    "You hear hissing",
    "Null, this isnt an error just checking...",
    "Sleep did not come easily that night in the depth of the dungeon for the the wall only portrayed the deformed, the decrepit and the damned. Sleep may never come easily you ever again.",
    "You hear your mother calling you deeper into the dungeon.",
    "A spider bites your toe."

  };
  public static final String[][] traps = new String[][] {
    { "You trigger a tripwire", "Luckily, you fell causing an arrow to fly above your head", "You took an arrow to the knee!", "The arrow pierced your heart, killing you." },
    { "You trigger a guillitine", "Thinking quickly you grab the shield of a fallen adventure, shielding yourself from near death.", "You try to dodge the massive blade, but it chops your right toe off.", "The Blade comes crushing down with intense speed slicing your head off, you see your body fall as the blood leaves your brain." },
    { "You Step on a pressure plate", "You take your foot away slowly, to your amazement, the plate does nothing the trap is broken", "The trap springs to life, but the spikes within this ancient trap have long since dulled.", "The room imediately bursts into flames." },
    { "You come to a bridge, over a dark river. You hear a creek", "It was nothing, keep walking", "A board cracks splintering your leg", "You fall through bridge into the murky river blow, struggling to get a float you see a large creature coming near you. Before you can react it swollows you whole." },
    { "You kick a rock, it sets of a trap", "This trap, fails completely.", "The trap sets off a flurry of blow darts, one hits you in the shoulder.", "The room comes to life, whirls, and whisps whisle by as millions of little darts sting your body, you stumble. You feel fire burning inside your vains. Death by posion." }
  };
  public static final String[] chests = new String[]{
    "You find a glorious chest, overflowing with gold coins.",
    "You spot a rickety old chest.",
    "You spot a boarded up cave, inside you see a plain box",
    "Inside a spider web their is a red box with a dragon inscribed on it.",
    "You spot a Chest.",
    "You spot a case.",
    "You spot a box.",
    "You spot a plain box, but get an overwhelming feeling of its importance.",
    "You spot a moss covered chest",
    "You spot a silver Chest.",
    "You spot a golden chest.",
    "You spot a bronze chest.",
    "You spot ye old chest",
    "you spot Black Birds Chest, sadly it feels empty and full of empty promises",
    "You spot prolevels chest, it feels smooth to the touch, Its said to be made of game fibers, but a steamboat captain told you that its really just cotton.",
    "You spot a chest made of pure gold, which has the cross of thy lord inscribed on it."
  };
  public static final String[] potions = new String[]{
    "You picked up a potion from a dead adventurer",
    "You find a rusty board, on futher inspection you see it that if is hiding a... *** ** POTION ** ***",
    "You find a potion, at the base of a Whomping Willow.",
    "You find a potion in the wrackage of a horseless Carriage.",
    "A man in the Shadows, gives you a potion, only to disapear before you can reply.",
    "You find a potion at an abandoned campsite",
    "You find a potion behind a rock",
    "You fiind a potion inside a creepy alter",
    "You find a potion under your pillow",
    "You find a potion in a babbling brook",
    "You found a potion in an old chest.",
    "You pick up a potion from the cold dead hands of your mothers ghost made real.",
    "You are made to endure the trial of nine, you are rewarded with a potion.. oh.. joy.."
  };
  public static final String[] attack_unarmed = new String[]{
    "You flail wildly",
    "fist clentched, you throw a punch directly for the dick",
    "Body slam",
    "Kick",
    "Punch",
    "Hyper fang",
    "twisting wildly you poke your enemy.",
    "upper cut",
    "grapping for anything near by, you find a stick, it breaks as you bring it crashing down on your foes skull."
  };
  public static String[] object_from(String[][] collection) { return collection[(int)(Math.random()*collection.length)]; }
  public static String text_from(String[] collection) { return collection[(int)(Math.random()*collection.length)].toString(); }
  public static String potion() { return text_from(FlavorText.potions); }
  public static String story() { return text_from(FlavorText.story_pieces); }
  public static String unarmed() { return text_from(FlavorText.attack_unarmed); }
  public static String chest() { return text_from(FlavorText.chests); }
  public static String[] trap() { return object_from(FlavorText.traps); }
}
