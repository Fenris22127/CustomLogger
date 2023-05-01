package de.custom.logger;

@SuppressWarnings("unused")
public class FormatColor {

    /**
     * Resets the text color
     */
    public static final String RESET = "\033[0m";

    // Regular Colors
    /**
     * Sets the color to <span color="rgb(12, 12, 12)">Black</span>
     */
    public static final String BLACK = "\033[0;30m";
    /**
     * Sets the color to <span color="#C50F1F">Red</span>
     */
    public static final String RED = "\033[0;31m";
    /**
     * Sets the color to <span color="rgb(19,161,14)">Green</span>
     */
    public static final String GREEN = "\033[0;32m";
    /**
     * Sets the color to <span color="rgb(193,156,0)">Yellow</span>
     */
    public static final String YELLOW = "\033[0;33m";
    /**
     * Sets the color to <span color="rgb(0,55,218)">Blue</span>
     */
    public static final String BLUE = "\033[0;34m";
    /**
     * Sets the color to <span color="rgb(136,23,152)">Purple</span>
     */
    public static final String PURPLE = "\033[0;35m";
    /**
     * Sets the color to <span color="rgb(58,150,221)">Cyan</span>
     */
    public static final String CYAN = "\033[0;36m";
    /**
     * Sets the color to <span color="#CCCCCC">White</span>
     */
    public static final String WHITE = "\033[0;37m";

    // Bold
    /**
     * Sets the color and font weight to <b color="rgb(12, 12, 12)">Black</b>
     */
    public static final String BLACK_BOLD = "\033[1;30m";
    /**
     * Sets the color and font weight to <b color="#C50F1F">Red</b>
     */
    public static final String RED_BOLD = "\033[1;31m";
    /**
     * Sets the color and font weight to <b color="rgb(19,161,14)">Green</b>
     */
    public static final String GREEN_BOLD = "\033[1;32m";
    /**
     * Sets the color and font weight to <b color="rgb(193,156,0)">Yellow</b>
     */
    public static final String YELLOW_BOLD = "\033[1;33m";
    /**
     * Sets the color and font weight to <b color="rgb(0,55,218)">Blue</b>
     */
    public static final String BLUE_BOLD = "\033[1;34m";
    /**
     * Sets the color and font weight to <b color="rgb(136,23,152)">Purple</b>
     */
    public static final String PURPLE_BOLD = "\033[1;35m";
    /**
     * Sets the color and font weight to <b color="rgb(58,150,221)">Cyan</b>
     */
    public static final String CYAN_BOLD = "\033[1;36m";
    /**
     * Sets the color and font weight to <b color="#CCCCCC">White</b>
     */
    public static final String WHITE_BOLD = "\033[1;37m";

    // Underline
    /**
     * Sets the color and text-decoration to <span style="text-decoration: underline; color: rgb(12, 12, 12);">Black</span>
     */
    public static final String BLACK_UNDERLINED = "\033[4;30m";
    /**
     * Sets the color and text-decoration to <span style="text-decoration: underline; color: #C50F1F;">Red</span>
     */
    public static final String RED_UNDERLINED = "\033[4;31m";
    /**
     * Sets the color and text-decoration to <span style="text-decoration: underline; color: rgb(19,161,14);">Green</span>
     */
    public static final String GREEN_UNDERLINED = "\033[4;32m";
    /**
     * Sets the color and text-decoration to <span style="text-decoration: underline; color: rgb(193,156,0);">Yellow</span>
     */
    public static final String YELLOW_UNDERLINED = "\033[4;33m";
    /**
     * Sets the color and text-decoration to <span style="text-decoration: underline; color: rgb(0,55,218);">Blue</span>
     */
    public static final String BLUE_UNDERLINED = "\033[4;34m";
    /**
     * Sets the color and text-decoration to <span style="text-decoration: underline; color: rgb(136,23,152);">Purple</span>
     */
    public static final String PURPLE_UNDERLINED = "\033[4;35m";
    /**
     * Sets the color and text-decoration to <span style="text-decoration: underline; color: rgb(58,150,221);">Cyan</span>
     */
    public static final String CYAN_UNDERLINED = "\033[4;36m";
    /**
     * Sets the color and text-decoration to <span style="text-decoration: underline; color: #CCCCCC;">White</span>
     */
    public static final String WHITE_UNDERLINED = "\033[4;37m";

    // Background
    /**
     * Sets the color and background to <span style="background-color: rgb(12, 12, 12); color: #CCCCCC;">Black</span>
     */
    public static final String BLACK_BACKGROUND = "\033[40m";
    /**
     * Sets the color and background to <span style="background-color: #C50F1F; color: #CCCCCC;">Red</span>
     */
    public static final String RED_BACKGROUND = "\033[41m";
    /**
     * Sets the color and background to <span style="background-color: rgb(19,161,14); color: #CCCCCC;">Green</span>
     */
    public static final String GREEN_BACKGROUND = "\033[42m";
    /**
     * Sets the color and background to <span style="background-color: rgb(193,156,0); color: rgb(12, 12, 12);">Yellow</span>
     */
    public static final String YELLOW_BACKGROUND = "\033[43m";
    /**
     * Sets the color and background to <span style="background-color: rgb(0,55,218); color: #CCCCCC;">Blue</span>
     */
    public static final String BLUE_BACKGROUND = "\033[44m";
    /**
     * Sets the color and background to <span style="background-color: rgb(136,23,152); color: #CCCCCC;">Purple</span>
     */
    public static final String PURPLE_BACKGROUND = "\033[45m";
    /**
     * Sets the color and background to <span style="background-color: rgb(58,150,221); color: #CCCCCC;">Cyan</span>
     */
    public static final String CYAN_BACKGROUND = "\033[46m";
    /**
     * Sets the color and background to <span style="background-color: #CCCCCC; color: rgb(12, 12, 12);">White</span>
     */
    public static final String WHITE_BACKGROUND = "\033[47m";

    // High Intensity
    /**
     * Sets the color to <span color="rgb(118,118,118)">Black</span>
     */
    public static final String BLACK_BRIGHT = "\033[0;90m";
    /**
     * Sets the color to <span color="rgb(231,72,86)">Red</span>
     */
    public static final String RED_BRIGHT = "\033[0;91m";
    /**
     * Sets the color to <span color="rgb(19,161,14)">Green</span>
     */
    public static final String GREEN_BRIGHT = "\033[0;92m";
    /**
     * Sets the color to <span color="rgb(249,241,165)">Yellow</span>
     */
    public static final String YELLOW_BRIGHT = "\033[0;93m";
    /**
     * Sets the color to <span color="rgb(59,120,255)">Blue</span>
     */
    public static final String BLUE_BRIGHT = "\033[0;94m";
    /**
     * Sets the color to <span color="rgb(180,0,158)">Purple</span>
     */
    public static final String PURPLE_BRIGHT = "\033[0;95m";
    /**
     * Sets the color to <span color="rgb(97,214,214)">Cyan</span>
     */
    public static final String CYAN_BRIGHT = "\033[0;96m";
    /**
     * Sets the color to <span color="#FFFFFF">White</span>
     */
    public static final String WHITE_BRIGHT = "\033[0;97m";

    // Bold High Intensity
    /**
     * Sets the color and font weight to <b color="rgb(118,118,118)">Black</b>
     */
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m";
    /**
     * Sets the color and font weight to <b color="rgb(231,72,86)">Red</b>
     */
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";
    /**
     * Sets the color and font weight to <b color="rgb(19,161,14)">Green</b>
     */
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m";
    /**
     * Sets the color and font weight to <b color="rgb(193,156,0)">Yellow</b>
     */
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";
    /**
     * Sets the color and font weight to <b color="rgb(0,55,218)">Blue</b>
     */
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";
    /**
     * Sets the color and font weight to <b color="rgb(136,23,152)">Purple</b>
     */
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";
    /**
     * Sets the color and font weight to <b color="rgb(0,255,255)">Cyan</b>
     */
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";
    /**
     * Sets the color and font weight to <b color="#FFFFFF">White</b>
     */
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m";

    // High Intensity backgrounds
    /**
     * Sets the color and background to <span style="background-color: rgb(118,118,118); color: #CCCCCC;">Black</span>
     */
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";
    /**
     * Sets the color and background to <span style="background-color: rgb(231,72,86); color: #CCCCCC;">Red</span>
     */
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";
    /**
     * Sets the color and background to <span style="background-color: rgb(19,161,14); color: #CCCCCC;">Green</span>
     */
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";
    /**
     * Sets the color and background to <span style="background-color: rgb(249,241,165); color: rgb(12, 12, 12);">Yellow</span>
     */
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";
    /**
     * Sets the color and background to <span style="background-color: rgb(59,120,255); color: #CCCCCC;">Blue</span>
     */
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";
    /**
     * Sets the color and background to <span style="background-color: rgb(180,0,158); color: #CCCCCC;">Purple</span>
     */
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m";
    /**
     * Sets the color and background to <span style="background-color: rgb(97,214,214); color: rba();">Cyan</span>
     */
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";
    /**
     * Sets the color and background to <span style="background-color: #FFFFFF; color: rgb(12, 12, 12);">White</span>
     */
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";

    /**
     * A private constructor to hide the implicitly public one
     */
    private FormatColor() {
    }
}
