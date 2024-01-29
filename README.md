# Rapport Projet AppDesign01:
Première version réalisée en Jetpack Compose, après beaucoup de difficultés et de manipulations pour avoir une structure idéale, j'ai recommencé le projet, cette fois en XML+Kotlin.
Version XML (ici présente):
## activity_main.xml :
* Création de plusieurs layouts (horizontaux et certains verticaux), ceux ci permettent d'organiser les boutons pour plus ou moins respecter la structure proposée par le Figma.
* Une fois les boutons initialisés (id étant buttonXXX avec XXX l char ou string à manipuler), j'ai créé button_shape.xml afin d'appliquer une strucutre précise
* Apres structure des margins emplacements et gravity des boutons je suis passé aux deux txt, qui corresponderont aux zones de textes qui s'occuperont des calculs et autres manipulations
* outputTxt et stepsTxt appartiennent à un même Layout pour une meilleure structure. L'un est plus grand (et "bold") que l'autre pour la mise en valeur du résultat.
## MainActivity.kt :
* Création des variables (ou val ici plutôt que var) qui seront utilisées, que ce soient les boutons ou txts. (Le bouton AC a une couleur de texte différente du reste)
* Ajout de la logique des boutons en fonction de la fonctionnalité souhaitée, comme pour le bouton AC, "=", ou backspace. Le bouton "=" appelle evaluateExpression() qui se charge de réaliser le calcul nécessaire de l'expression entrée.
* evaluateExpression(), transformExpression() et calculate() sont utiliser pour gérer la logique mathématique, je me suis basé sur du code déjà existant pour ce genre de logique, que j'ai modifié plus tard. Les calculs sur les opérateurs de base semblent bien fonctionner.
* REMARQUE: dans le cas où l'expression calculée est trop grande cela peut créer des perturbations sur le outputTxt. Je ne sais pas comment régler ce problème, peut être ajouter des contraintes spécifiques qui rétreciront la textbox.
## button_shape.xml :
* La shape rectangle permet d'avoir les coins comme demandé sur le Figma, les corners sont ajustés au fur et à mesur et je pense que des Radius de 8dp répondent bien à la problématique.
## colors.xml :
* Sert à déterminer la couleur de base pour le texte vu que j'ai des difficultés à utiliser les styles dans le XML.my_text_color sera utilisé dans MainActivity.kt
* Cependant la couleur que j'ai appliqué ne semble pas fonctionner directement, j'ai donc décider d'utiliser des thèmes comme solution secondaire. 
## themes.xml :
* Les themes m'auront permit de changer la couleur "purple" par défaut en un blanc comme demandé, cependant je n'arrive pas à créer plusieurs thèmes (ou du moins à les appliquer) ce qui fait que tous mes boutons restent blancs. J'aurais eu besoin d'aide sur ce point spécifique.



## Conclusion:
La calculatrice fonctionne plutôt bien, bien que le style ne soit pas exactement ce qui était demandé, je pense quand même avoir réussi à reproduire la plupart des éléments demandés en plus d'avoir ajouté la logique mathématique derrière.
* Changer de langage en milieu de projet m'a beaucoup retardé en plus du problème que j'ai rencontré concernant les contraintes (que j'ai envoyé et relancé par mail et que j'ai résolu entre temps). Mais je suis quand même plutôt satisfait de mon projet même si j'aurai voulu résoudre mon problème de couleurs et thèmes. Je poserai la question en TD pour pouvoir l'appliquer au prochain projet.
