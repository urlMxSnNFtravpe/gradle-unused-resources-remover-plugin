package com.github.konifar.gradle.remover

import com.github.konifar.gradle.remover.remover.filetype.*
import com.github.konifar.gradle.remover.remover.valuetype.*
import org.gradle.api.Plugin
import org.gradle.api.Project

class UnusedResourcesRemoverPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.task("removeUnusedResources").doLast {

            [
                    new LayoutFileRemover(),
                    new MenuFileRemover(),
                    new MipmapFileRemover(),
                    new DrawableFileRemover(),
                    new AnimatorFileRemover(),
                    new AnimFileRemover(),
                    new ColorFileRemover(),
            ].forEach {
                it.remove(project)
            }

            [
                    new ThemeXmlValueRemover(),
                    new StyleXmlValueRemover(),
                    new StringXmlValueRemover(),
                    new DimenXmlValueRemover(),
                    new FloatXmlValueRemover(),
                    new ColorXmlValueRemover(),
                    new IntegerXmlValueRemover(),
                    new BoolXmlValueRemover(),
                    new IdXmlValueRemover(),
                    // new AttrXmlTagRemover(),
                    // new FontCertsXmlTagRemover(),
            ].forEach {
                it.remove(project)
            }

        }
    }

}