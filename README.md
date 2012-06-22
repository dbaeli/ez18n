ez18n
=====

apt: 30min (gilles)
-------------------

[ez18n_apt_in_nutshell.pptx](ez18n-slides/ez18n_apt_in_nutshell.pptx?raw=true "ez18n_apt_in_nutshell.pptx")

[ez18n_apt_in_nutshell.pdf](ez18n-slides/ez18n_apt_in_nutshell.pdf?raw=true "ez18n_apt_in_nutshell.pdf")


* APT qu'est ce que c'est
* appeler en ligne de commande
* appeler APT depuis maven
* l'API javax.tools - hierarchie des classes
* Processor
* meta model d'un fichier source java
* comparaison avec java.lang.reflect
* limitation par rapport à java.lang.reflect
* ca sert à quoi ?
* pattern avec injection - je fais un framework
* analyse et transformation de code vers des fichiers plats
* DSL avec des annotations
* no limit ... attention aux dépendances
* compilation une ou deux passes ?
* APT dans mon IDE

encoding et gouvernance : i18n, l10n: 30min (dimitri)
-----------------------------------------------------

[ez18n_theorie.pptx](ez18n-slides/ez18n_theorie.pptx?raw=true "ez18n_theorie.pptx")

[ez18n_theorie.pdf](ez18n-slides/ez18n_theorie.pdf?raw=true "ez18n_theorie.pdf")

* ISO-8859-1 Au secours !
* Téléphone japonais
* Gruyère international
* i18n ?
* i18n ou l10n
* Le champ d'action
* Pour le fun: les guillemets
* i18n en java
* MessageFormat
* Démo : Old style i18n
* Exemples
* The absolute minimum
* Le minimum
* Encodings
* Idées au passage
* Des outils

[pause]

Pattern APT, plugin maven, gwt:  45min (gilles)
-----------------------------------------------

[ez18n_hands_on.pptx](ez18n-slides/ez18n_hands_on.pptx?raw=true "ez18n_hands_on.pptx")

[ez18n_hands_on.pdf](ez18n-slides/ez18n_hands_on.pdf?raw=true "ez18n_hands_on.pdf")

* Introduction à i18n avec GWT
* les ResourceBundle du JDK
* les MessageFormats du JDK
* Comment aligner les 2 mondes ?
* Bénéfices d'une approche unifiée
* Injection à la CDI des bundles
* Testes unitaires
* Rapport CSV des clés i18n
* Application multi écran
* Demo slideware : LesFurets.com mobile/desktop 
* On enrichit encore un peu le pattern !
* Deffered binding GWT kesako ?
* Une nouvelle permutation GWT pour les clients mobiles
* Injection des resources mobile et desktop avec GWT
* Demo StockWatcher
* Idée 1 : des tests JUnit pour l'orthographe
* Idée 2 : un JSR pour les ResourceBundle 2.0

Traduction via Excel & Crowd Sourcing: 15min (dimitri)
------------------------------------------------------

[ez18n_crowdsourcing.pptx](ez18n-slides/ez18n_crowdsourcing.pptx?raw=true "ez18n_crowdsourcing.pptx")

[ez18n_crowdsourcing.pdf](ez18n-slides/ez18n_crowdsourcing.pdf?raw=true "ez18n_crowdsourcing.pdf")

* Besoin de gouvernance
* Externaliser l'internalisation !
* Vraiment pas satisfaisant
* Not Invented Here (NIH)
* Et arrive le crowd sourcing
* Babili Crowdin.net
* Aides à la traduction
* Le sommet de l'iceberg

QA : 15min
----------