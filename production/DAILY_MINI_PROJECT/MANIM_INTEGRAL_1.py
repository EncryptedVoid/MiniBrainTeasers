from manim import *


class IntegralVisualization(Scene):
    def construct(self):
        title = Tex(r"Evaluate $\int \frac{\sin^2(x)}{(1 + \cos(x))^2} \, dx$")
        title.to_edge(UP)

        self.play(Write(title))
        self.wait(2)

        steps = [
            r"\sin^2(x) = 1 - \cos^2(x)",
            r"\int \frac{1 - \cos^2(x)}{(1 + \cos(x))^2} \, dx",
            r"\frac{1 - \cos^2(x)}{(1 + \cos(x))^2} = \frac{(1 + \cos(x))(1 - \cos(x))}{(1 + \cos(x))^2} = \frac{1 - \cos(x)}{1 + \cos(x)}",
            r"u = 1 + \cos(x), \, du = -\sin(x) \, dx",
            r"\int \frac{1 - \cos(x)}{1 + \cos(x)} \, dx = \int \frac{1 - (u - 1)}{u} (-du)",
            r"\int \left(\frac{2}{u} - 1\right) (-du) = -2 \int \frac{1}{u} \, du + \int du",
            r"-2 \ln|u| + u + C",
            r"-2 \ln|1 + \cos(x)| + (1 + \cos(x)) + C"
        ]

        previous_step = title
        for step in steps:
            step_tex = MathTex(step)
            self.play(Write(step_tex))
            self.wait(2)
            self.play(step_tex.animate.next_to(previous_step, DOWN))
            previous_step = step_tex

        final_result = MathTex(
            r"\int \frac{\sin^2(x)}{(1 + \cos(x))^2} \, dx = -2 \ln|1 + \cos(x)| + (1 + \cos(x)) + C")
        self.play(Write(final_result))
        self.wait(2)
        self.play(final_result.animate.next_to(previous_step, DOWN))

        self.wait(2)
