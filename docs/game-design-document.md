# STUFFY KARTS

## GRAND PRIX

### EDGE: Act of Elation

> A deceptively cute kart-combat game where getting hit makes you heavier, slower, and more unstable — until you decide to expel the accumulated Burden back at everyone behind you.

---

## 1. High Concept

**Stuffy Karts** is a small arcade kart-racing / battle game built around one ridiculous but mechanically coherent idea: attacks do not simply remove health or spin a racer out. Instead, many attacks become **Burden**.

Burden physically and mechanically accumulates on the kart. As a racer becomes more overloaded, the kart loses speed, handling becomes stiffer, and the suspension visibly compresses. The player must decide whether to keep carrying that Burden or trigger an **Expel** action that clears it and converts the stored disadvantage into an offensive rear-discharge attack and forward boost.

The core loop is therefore:

**receive → accumulate → slow down → decide when to expel → weaponize accumulated damage**

The game should look bright, rounded, toy-like, and approachable while its names, announcer lines, mechanics, and presentation become increasingly questionable once the player notices the double meanings.

The comedy rule is simple:

> **Everything should have a defensible racing or engineering interpretation until context betrays it.**

---

## 2. Project Goal

This is intended to be a **small, finishable Strawberry Jam-style game**, not a full commercial kart-racing project.

The initial goal is to prove three things:

1. The Burden system is genuinely fun rather than only funny.
2. Expelling accumulated Burden creates a useful risk/reward decision.
3. The deceptively cute presentation and layered naming jokes work together without requiring a huge content roster.

A polished small build is more important than a large unfinished feature set.

---

## 3. Tone & Presentation

### Visual tone

The visual style should be:

- Bright and colorful
- Rounded and toy-like
- Slightly exaggerated
- Arcade-first rather than realistic
- Cute enough that the underlying joke lands through contrast
- Mechanically readable at a glance

The target feeling is a cheerful kart racer whose design becomes increasingly cursed the longer the player pays attention.

### Comedy style

The humor should come from layered interpretation rather than simply putting explicit jokes everywhere.

Recurring joke structures include:

- **Acronym names** that appear innocent until decoded
- **Phonetic names** that become suspicious when spoken aloud
- **Racing terminology** with accidental second meanings
- **Engineering language** that becomes incriminating in context
- **Deadpan announcer lines** describing absurd mechanics as if they were normal motorsport

The game should reward the player for noticing the joke rather than explaining every joke to them.

---

## 4. Title & Branding

Primary title lockup:

```text
STUFFY KARTS
  GRAND PRIX
        EDGE: Act of Elation
```

### Branding hierarchy

- **Stuffy Karts** — primary game title / franchise name
- **Grand Prix** — racing-series framing
- **EDGE: Act of Elation** — faux-serious edition / subtitle line

The typography should help hide the phonetic joke rather than advertise it.

### Candidate tagline

> **Pack it in. Let it rip.**

Additional candidate lines:

- Hold your load. Win the road.
- Stuff more. Drift harder.
- Pressure makes champions.
- Cute on the outside. Competitive underneath.

---

## 5. Core Mechanics

### 5.1 Burden Stacking

Many offensive items lodge into or are absorbed by a target kart rather than causing a conventional health loss.

Each lodged item adds one or more **Burden levels**.

Per Burden stack, the current baseline design is:

- Top speed reduced by **8%**
- Handling stiffness increased by **10%**
- Suspension compression increased visually

Burden should remain a deterministic gameplay state. Physics may reflect the visual weight, but raw rigid-body mass should not be the sole authority for gameplay tuning.

Suggested implementation model:

```java
burden++;

topSpeed = baseTopSpeed * pow(0.92f, burden);
handling = baseHandling * pow(0.90f, burden);
suspensionCompression =
        baseSuspensionCompression + burden * compressionPerStack;
```

### 5.2 Expel Boost

The secondary action triggers an **Expel**.

Expelling:

- Clears the current Burden stacks
- Launches the accumulated payload backward
- Creates an offensive rear-facing projectile spread
- Applies a forward boost proportional to stored Burden

Core formula:

```text
Boost = BurdenCount × ForceMultiplier
```

Optional spread scaling:

```text
DischargeSpread = BaseSpread + BurdenCount × SpreadPerBurden
```

This creates a real tactical choice:

- **Small releases** are safer and precise.
- **Large releases** are riskier but produce stronger boosts and broader attacks.

### 5.3 Driving Feel

The driving model should favor fast arcade readability over simulation realism.

Important characteristics:

- Immediate acceleration feedback
- Strong visual suspension response
- Readable drifting
- Burden clearly affects kart behavior
- Physics collisions are funny but should not dominate control
- Players should quickly understand why a kart feels worse when overloaded

---

## 6. Racers

The racer names themselves are part of the game’s joke system.

### T. HOT

**Name:** Tiffany Tighterson  
**Nickname:** High Octane  
**Display identity:** **T. HOT**  
**Features:** High acceleration, low weight  
**Personality:** Chaotic

Tiffany should feel explosive and twitchy: fast off the line, easy to upset, and ideal for players who enjoy aggressive acceleration and risky play.

---

### P. AWG

**Name:** Page Gagmon  
**Extended name:** Page “All-the-Way” Gagmon  
**Nickname:** All the Way  
**Display identity:** **P. AWG**  
**Features:** High top speed, heavy build  
**Personality:** Bubbly

Page should contrast Tiffany by being heavier and harder to disturb, with stronger sustained speed but slower recovery.

---

### A. 2×M

**Name:** Amanda Moaner  
**Extended name:** Amanda “Two-Time” Moaner  
**Display identity:** **A. 2×M**  
**Features:** Balanced  
**Personality:** **TBD**

Amanda is the all-rounder and can serve as the easiest baseline for balancing the rest of the roster.

> **TODO:** Give Amanda a unique nickname; “High Octane” is already Tiffany’s identity.

---

### D.I.C.K.

**Name:** Danny Kook  
**Extended name:** Danny “Insta Clutch” Kook  
**Display identity:** **D.I.C.K.**  
**Nickname:** Insta Clutch  
**Features:** High handling, low drift  
**Personality:** **TBD**

Danny should feel precise and technical: excellent directional control and fast corrections, but less reward from long sweeping drifts.

---

## 7. Karts

Each kart should have an exaggerated silhouette and an immediately understandable gameplay identity.

### The Shaft

A sleek, long-frame speedster.

**Role:** Top-speed chassis  
**Visual language:** Long, narrow, pointed  
**Strength:** Straight-line speed  
**Weakness:** Less forgiving in tight courses

### Rear-Loader

A heavy-duty pickup-style kart built for carrying heavy Burden.

**Role:** Capacity / stability chassis  
**Visual language:** Chunky rear assembly, heavy suspension  
**Strength:** Burden tolerance  
**Weakness:** Acceleration and agility

### Tight-Squeeze

A compact kart with strong drift handling.

**Role:** Technical / cornering chassis  
**Visual language:** Short wheelbase, tight proportions  
**Strength:** Drift and confined spaces  
**Weakness:** Lower stability under heavy impact

### The Penetrator

A kart with a pointed front bumper built for drafting and rear-end collisions.

**Role:** Aggressive contact chassis  
**Visual language:** Wedge-shaped nose  
**Strength:** Drafting and impact play  
**Weakness:** Less defensive stability

---

## 8. Items

The item set should be original and mechanically readable rather than directly copying recognizable Nintendo item designs.

### P.L.U.G.

**Posterior Launched Universal Guard**

Deploys behind the kart to block one incoming rear attack.

If struck, the attack is absorbed as **Burden** instead of immediately spinning the kart out.

**Role:** Defensive conversion item

---

### G.A.P.E.

**General Area Purge Emitter**

Instantly expels all currently accumulated Burden.

Effects:

- Clears Burden
- Fires the stored payload backward as a shotgun-style cluster
- Provides an immediate nitro-like forward boost

**Role:** Tactical purge / comeback item

---

### D.I.L.D.O.

**Directional Impact Long-Distance Ordnance**

A rear-seeking homing projectile that lodges into the target kart and applies **+1 Burden**.

**Role:** Precision homing attack

---

### L.U.B.E.

**Liquid Ultra-Slick Friction Eliminator**

Drops a slick hazard on the track.

A hit kart temporarily loses steering authority and slides forward violently.

**Role:** Area denial / handling disruption

---

### B.U.T.T.

**Blast Utility Tactical Torpedo**

A heavy forward-fired missile.

Effects:

- Strong explosive physics knockback
- Applies **+2 Burden** on direct hit

**Role:** Heavy offensive weapon

---

## 9. Race Courses

### F.I.S.T.

**Future Industries Speed Trail**

A high-tech industrial circuit filled with tight tunnels, machinery, hard walls, and rapid transitions.

**Gameplay identity:** Technical tunnel racing

---

### B.B. Coast

**Back Breakers Coast**

A winding cliffside road with heavy drops, sharp bends, and dangerous outside edges.

**Gameplay identity:** Momentum and risk management

---

### C.O.C.K. Pit

**Central Offshore Control Complex**

A water-logged industrial platform track built over an offshore control facility.

**Gameplay identity:** Narrow platforms, wet surfaces, exposed edges

---

### S.L.U.T. Runway

**Sub-Level Underground Transit**

An abandoned underground transit system featuring split pathways, tunnels, and alternate routes.

**Gameplay identity:** Route choice and close quarters

---

### A.N.A.L. Highway

**Automated Northern Access Loop**

An open multi-lane highway with heavy traffic hazards and broad high-speed sections.

**Gameplay identity:** Speed, traffic weaving, and drafting

---

### V.A.G. Valley

**Volcanic Ash & Geyser Valley**

A cavernous volcanic track with narrow gaps, geysers, steam vents, and ash-filled visibility changes.

**Gameplay identity:** Environmental hazards and timing

---

## 10. Battle Course

### D. P-ark

**Destruction Parkway**

A circular combat arena centered around a pit hazard with dynamic item spawners.

**Gameplay identity:** Direct kart combat and Burden manipulation

The arena should support short matches where the Burden / Expel mechanic can be tested without requiring full racing AI or lap logic.

---

## 11. Tournament Mode

### OVERLOADED! Final

Tournament structure:

- Three tracks selected from the six race courses
- Position-based race points
- Bonus scoring categories

Bonus awards:

- **Most Burden Inflicted**
- **Cleanest Rear**

The scoring system should reward both racing performance and effective use of the game’s signature mechanics.

---

## 12. Announcer Language

The announcer should treat everything with completely straight-faced sports commentary.

Candidate lines:

- “And they’re fully loaded already!”
- “Direct hit! Burden increased!”
- “That rear handling is getting unstable!”
- “They can’t hold much more!”
- “That kart is bottoming out!”
- “Massive pressure building in the back!”
- “Big release on turn three!”
- “They’ve expelled the whole load!”
- “Rear pressure critical!”
- “What a finish!”
- “That was a full send!”
- “What an Act of Elation!”

The funniest lines should also be mechanically informative.

---

## 13. End-of-Race Presentation

The results screen should celebrate conventional racing stats alongside increasingly questionable performance metrics.

Potential statistics:

- Finish position
- Best lap
- Top speed
- Burden received
- Burden inflicted
- Largest single Expel
- Expel boost distance
- Cleanest Rear
- Most overloaded moment
- Rear attacks blocked

This screen is an opportunity for the game’s deadpan tone to shine.

---

## 14. Jam Scope

The complete design currently includes more content than a tiny jam prototype needs.

### Recommended playable MVP

**Racers:**

- T. HOT
- P. AWG

**Karts:**

- The Shaft
- Rear-Loader

**Race tracks:**

Start with one track, then expand only if the core loop is already fun.

Recommended first candidates:

1. F.I.S.T. — compact and technically useful for testing handling
2. A.N.A.L. Highway — useful for testing speed, traffic, and drafting
3. V.A.G. Valley — useful for demonstrating environmental identity

**Items:**

- P.L.U.G.
- D.I.L.D.O.
- G.A.P.E.

Those three items alone prove the complete signature loop:

**attack → Burden → defensive conversion → accumulation → purge → counterattack**

### Expansion after the loop works

Only after the prototype is fun should development add:

- Remaining racers
- Remaining karts
- L.U.B.E.
- B.U.T.T.
- Additional race tracks
- D. P-ark battle mode
- Tournament scoring
- Extended announcer VO

---

## 15. Technical Direction

Current intended platform structure:

```text
stuffy-karts/
├── app/        # Android launcher/platform code
├── desktop/    # Desktop launcher/platform code
├── game/       # Shared jMonkeyEngine game code
├── docs/       # Design and development documentation
├── build.gradle
├── settings.gradle
└── gradle/
```

### Engine / language

- Java
- jMonkeyEngine 3
- Bullet physics where useful
- Android + desktop targets

The shared `game` module should contain almost all gameplay logic:

- Kart control
- Burden system
- Items
- Track logic
- Race state
- AI
- HUD data
- Scoring

Platform launchers should remain thin.

### Physics principle

Use physics to enhance the comedy and physicality of the game, but keep core gameplay tuning deterministic.

Burden should be a game-state variable first and a rigid-body side effect second.

---

## 16. Design Pillars

### 1. The joke must also be a mechanic

The Burden / Expel system should remain enjoyable even if the player ignores every innuendo.

### 2. Cute first, cursed second

The presentation should invite players in before they realize what they are looking at.

### 3. Racing terminology is part of the comedy

Normal phrases such as “Bottom Out,” “Final Stretch,” “Pole Positioned,” “Bumper to Bumper,” “Backfire,” and “Overloaded” become funnier through context.

### 4. Do not explain every joke

Discovery is part of the experience.

### 5. Finish the tiny version

One excellent racer matchup, one good course, and a working Burden loop are more valuable than six unfinished tracks.

---

## 17. Naming Pool / Reserved Ideas

Potential future cup, mode, track, or event names:

- Pro Laps
- Bum Rush
- Final Stretch
- Overloaded!
- Bumper to Bumper
- Cheek to Cheek
- Pole Positioned
- Backfire!
- Bottom Out!
- Grand Rear
- Touche Kart
- Bumper Buddies
- Rear End Rally
- Payload Panic
- Tailpipe Trouble
- Hold Your Load
- Expel!
- Eat My Gust
- Stuffy Kart Racing

Additional phonetic / hidden-joke racer-name experiments discussed during ideation include:

- Sukama DiMami
- Fukuchi Fooka
- Fukuchi Anaru
- Fooka DiMami
- Daiki Peko

These are concept-pool names and are not part of the confirmed playable roster unless promoted later.

---

## 18. Open Questions

- What is Amanda’s final personality and nickname?
- What is Danny’s final personality?
- Which kart belongs naturally to each racer in the first playable build?
- What course should be the first fully implemented race track?
- Should D. P-ark be implemented before full race AI as a mechanics sandbox?
- How much Burden should a kart safely carry before handling becomes nearly unmanageable?
- Should Expel be player-triggered only, or should an extreme Burden threshold force an automatic release?
- Should stored projectiles remain visually distinct or collapse into a simplified deforming rear-storage silhouette?
- How much procedural deformation is useful before it becomes unnecessary scope?
- Which announcer lines are funniest while still communicating useful gameplay information?

---

## 19. Definition of Success

The jam prototype succeeds if two players can race or battle, laugh at the presentation, and still make meaningful tactical decisions about Burden.

The moment the player thinks:

> “I should probably expel now… but if I hold one more hit, the counterattack will be huge.”

—the mechanic is working.

Everything after that is stuffing.