# Rapport Projet AppDesign01:
Première version réalisée en Jetpack Compose, après beaucoup de difficultés et de manipulations pour avoir une structure idéale, j'ai recommencé le projet, cette fois en XML+Kotlin.
Version XML (ici présente):
## activity_main.xml :
* Création de plusieurs layouts (horizontaux et certains verticaux), ceux ci permettent d'organiser les boutons pour plus ou moins respecter la structure proposée par le Figma.
* Une fois les boutons initialisés (id étant buttonXXX avec XXX l char ou string à manipuler), j'ai créé button_shape.xml afin d'appliquer une strucutre précise
* Apres structure des margins emplacements et gravity des boutons je suis passé aux deux txt, qui corresponderont aux zones de textes qui s'occuperont des calculs et autres manipulations
* outputTxt et stepsTxt appartiennent à un même Layout pour une meilleure structure. L'un est plus grand (et "bold") que l'autre pour la mise en valeur du résultat.
## MainActivity.kt :
* 
## button_shape.xml :
* 
## colors.xml :
* 
## themes.xml :
* 
