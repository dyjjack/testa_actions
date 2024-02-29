package com.zcy.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Panel {

    @JsonProperty("type")
    private String type;

    @JsonProperty("title")
    private String title;

    @JsonProperty("gridPos")
    private GridPos gridPos;

    @JsonProperty("datasource")
    private Datasource datasource;

    @JsonProperty("id")
    private int id;

    @JsonProperty("targets")
    private List<Target> targets = new ArrayList<>();

    @JsonProperty("options")
    private Options options;

    @JsonProperty("fieldConfig")
    private FieldConfig fieldConfig;

    // Getters and setters for all properties

    @Data
    public static class GridPos {
        @JsonProperty("x")
        private int x;

        @JsonProperty("y")
        private int y;

        @JsonProperty("w")
        private int w;

        @JsonProperty("h")
        private int h;

        // Getters and setters for all properties
    }

    @Data
    public static class Datasource {
        @JsonProperty("uid")
        private String uid;

        @JsonProperty("type")
        private String type;

        // Getters and setters for all properties
    }

    @Data
    public static class Target {
        @JsonProperty("datasource")
        private Datasource datasource;

        @JsonProperty("refId")
        private String refId;

        @JsonProperty("frame")
        private Frame frame;

        // Getters and setters for all properties

        @Data
        public static class Frame {
            @JsonProperty("fields")
            private List<Field> fields = new ArrayList<>();

            @JsonProperty("meta")
            private Object meta; // Assuming meta can be any type, adjust as needed

            // Getters and setters for all properties

            @Data
            public static class Field {
                @JsonProperty("name")
                private String name;

                @JsonProperty("type")
                private String type;

                @JsonProperty("config")
                private Object config; // Assuming config can be any type, adjust as needed

                @JsonProperty("values")
                private List<Double> values = new ArrayList<>(); // Assuming values can hold any type, adjust as needed

                // Getters and setters for all properties
            }
        }
    }

    @Data
    public static class Options {
        @JsonProperty("tooltip")
        private Tooltip tooltip;

        @JsonProperty("legend")
        private Legend legend;

        // Getters and setters for all properties

        @Data
        public static class Tooltip {
            @JsonProperty("mode")
            private String mode;

            @JsonProperty("sort")
            private String sort;

            // Getters and setters for all properties
        }

        @Data
        public static class Legend {
            @JsonProperty("showLegend")
            private boolean showLegend;

            @JsonProperty("displayMode")
            private String displayMode;

            @JsonProperty("placement")
            private String placement;

            @JsonProperty("calcs")
            private List<Object> calcs = new ArrayList<>(); // Assuming calcs can hold any type, adjust as needed

            // Getters and setters for all properties
        }
    }

    @Data
    public static class FieldConfig {
        @JsonProperty("defaults")
        private Defaults defaults;

        @JsonProperty("overrides")
        private List<Object> overrides = new ArrayList<>(); // Assuming overrides can hold any type, adjust as needed

        // Getters and setters for all properties

        @Data
        public static class Defaults {
            @JsonProperty("custom")
            private Custom custom;

            @JsonProperty("unitScale")
            private boolean unitScale;

            @JsonProperty("color")
            private Color color;

            @JsonProperty("mappings")
            private List<Object> mappings = new ArrayList<>(); // Assuming mappings can hold any type, adjust as needed

            @JsonProperty("thresholds")
            private Thresholds thresholds;

            // Getters and setters for all properties

            @Data
            public static class Custom {
                private String drawStyle;
                private String lineInterpolation;
                private Integer barAlignment;
                private Integer lineWidth;
                private Float fillOpacity;
                private String gradientMode;
                private Boolean spanNulls;
                private Boolean insertNulls;
                private String showPoints;
                private Integer pointSize;
                private StackingConfig stacking;
                private String axisPlacement;
                private String axisLabel;
                private String axisColorMode;
                private Boolean axisBorderShow;
                private ScaleDistribution scaleDistribution;
                private Boolean axisCenteredZero;
                private HideFromConfig hideFrom;
                private ThresholdsStyleConfig thresholdsStyle;

                // Getters and setters for each field are omitted for brevity

                @Data
                public static class StackingConfig {
                    private String mode;
                    private String group;

                    // Getters and setters
                }

                @Data
                public static class ScaleDistribution {
                    private String type;

                    // Getters and setters
                }

                @Data
                public static class HideFromConfig {
                    private Boolean tooltip;
                    private Boolean viz;
                    private Boolean legend;

                    // Getters and setters
                }

                @Data
                public static class ThresholdsStyleConfig {
                    private String mode;

                    // Getters and setters
                }
            }

            @Data
            public static class Color {
                @JsonProperty("mode")
                private String mode;

                // Getters and setters for all properties
            }

            @Data
            public static class Thresholds {
                @JsonProperty("mode")
                private String mode;

                @JsonProperty("steps")
                private List<Step> steps = new ArrayList<>();

                // Getters and setters for all properties

                @Data
                public static class Step {
                    @JsonProperty("value")
                    private Object value; // Assuming value can be any type (e.g., null for the first step), adjust as needed

                    @JsonProperty("color")
                    private String color;

                    // Getters and setters for all properties
                }
            }
        }
    }
}