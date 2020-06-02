<h2 align=center>Rasterizer</h2>
<br>
<br>
<p align="center">
    <img src="https://img.shields.io/badge/Build%20Type-InDev-blue.svg?style=for-the-badge" alt="build">
    <img src="https://img.shields.io/badge/App%20Version-V0.0.1%20alpha-blue.svg?style=for-the-badge" alt="version"> 
</p>

* Ce programme est à la base une idée de <a href="https://github.com/Chaika9">Chaika9</a>, donc un grand merci à lui ♡＾▽＾♡

## Présentation

**Rasterizer, une petite console app qui va convertir une image passée en paramètre en un tableau qui contient plus ou moins des données (la plupart du temps c'est des couleurs en hexadécimal) pour chaque pixel dans cette image.**

*Requiert : Java 8 ou plus récent*

##### N'oublie pas de soutenir ce projet, en cliquant sur la petite étoile **🌟** des neiges 😉 

## Comment ça fonctionne 🤔 ?

***+ C'est très simple 👌***

1. Non testé sous Windows/MacOS mais normalement, ça doit marcher pour vous ! Suivez la partie linux en attendant que j'ajoute la partie Windows / MacOS

2. Sous Linux 
 
  Il suffit de double cliquer sur le .jar, si rien ne se passe ouvrez votre terminal **Ctrl + Alt + T**. 
  Soyez sûr que vous êtes dans le dossier dans lequel se trouve le **.jar** et executez la commande suivante :

  > java -jar rasterizer-0.0.1.jar

  Du texte va s'afficher, entrez le répertoire vers l'image que vous voulez convertir, par exemple:

  > home/nomd'utilisateurici/Images/myImage.jpg

  Parfait ! Maintenant, il suffit d'attendre que le traitement soit terminé et vous aurez un fichier **.html** dans le         répértoire **Images (Par défaut)**
  qui contient le plus souvent les couleurs en hexadecimal pour chaque pixel dans l'image ^^

## WARNING ##

Ce programme n'est vraiment vraiment pas opti pour quelque chose de gros ! Donc n'essayez pas de rasteriser des images de dimenssions supérieurs à 800x600 (ou 800x800) ! Sinon y'aura des crash anormaux, soit pendant la phase de convertion, soit pendant la phase de sauvegrade du fichier, ou même à l'ouverture du fichier de sauvegarde dans un Navigateur (le plus souvent)

Donc, au cas où vous avez tenté le coup et que ça a planté votre ordi, veuillez le redémarrer, supprimez le fichier et tout sera bien 🙂

**Y'aura des Updates importantes concernant les performances dans les jours qui suivent ^^**
